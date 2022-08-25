package com.thoughtworks.codepairing.model;

import java.util.List;
import java.util.stream.Collectors;
//购物车类
public class ShoppingCart {
    private List<Product> products;
    private Customer customer;

    public ShoppingCart(Customer customer, List<Product> products) {
        this.customer = customer;
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }
    //计算购物车中的商品总价，以及可以获得的积分
    public Order checkout() {
        double totalPrice = 0;//总价

        int loyaltyPointsEarned = 0;
        for (Product product : products) {//遍历所有商品
            double discount = 0;//折扣可以省下的钱
            if (product.getProductCode().startsWith("DIS_10")) {//打折90%的商品
                discount = (product.getPrice() * 0.1);//计算可以省的钱数
                loyaltyPointsEarned += (product.getPrice() / 10);//计算可以获得的积分（九折商品每满10元可获得1积分）
            } else if (product.getProductCode().startsWith("DIS_15")) {
                discount = (product.getPrice() * 0.15);
                loyaltyPointsEarned += (product.getPrice() / 15);//计算可以获得的积分（85折商品每满15元可获得1积分）
            } else {//正常商品满5元可以获得1积分
                loyaltyPointsEarned += (product.getPrice() / 5);
            }

            totalPrice += product.getPrice() - discount;//
        }
        //返回一个order对象，里面包含了总价格和可以获得的积分数
        return new Order(totalPrice, loyaltyPointsEarned);
    }

    @Override
    public String toString() {
        return "Customer: " + customer.getName() + "\n" + "Bought:  \n" + products.stream().map(p -> "- " + p.getName()+ ", "+p.getPrice()).collect(Collectors.joining("\n"));
    }
}
