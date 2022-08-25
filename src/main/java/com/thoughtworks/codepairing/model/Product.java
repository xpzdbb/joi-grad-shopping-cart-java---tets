package com.thoughtworks.codepairing.model;
//商品类
public class Product {
    private final double price;//价格
    private final String productCode;//商品打折信息
    private final String name;//商品名称

    public Product(double price, String productCode, String name) {
        this.price = price;
        this.productCode = productCode;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getName() {
        return name;
    }
}
