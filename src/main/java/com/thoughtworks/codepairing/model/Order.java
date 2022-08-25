package com.thoughtworks.codepairing.model;

public class Order {
    private double totalPrice;//总价格
    private int loyaltyPoints;//可以获取的积分

    public Order(double totalPrice, int loyaltyPointsEarned) {
        this.totalPrice = totalPrice;
        this.loyaltyPoints = loyaltyPointsEarned;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    @Override
    public String toString() {
        return "Total price: " + totalPrice + "\n" + "Will receive " + loyaltyPoints + " loyalty points";
    }
}
