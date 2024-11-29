package com.ecommerce;

/** <strong>This class represents a product available for purchase</strong> */
public class Product {

    private final String productID;
    private String name;
    private double price;

    /** <i>The amount of product left</i> */
    public int stock;

    /**
     * Include attributes like 
     * @param ID Unique ID of the product
     * @param name The name of the product
     * @param price The price of the product
     * and any other relevant fields. 
     * Implement the necessary constructors, getters, setters, and any other methods for product-related operations. 
    */
    public Product(String ID, String name, double price) {
        this.productID = ID;
        this.name = name;
        this.price = price;
        this.stock = 40;
    }

    public String getId() { return this.productID; }

    @Override
    public String toString() { return this.name; }

    public double getPrice() { return this.price; }

    /** Takes a string value and sets it as product name
     * @param str
     */
    public void setName(String str) { this.name = str; }

    /** Takes a double value and sets it as product price
     * @param newPrice
     */
    public void setPrice(double newPrice) { this.price = newPrice; }

    /** When called decrements the stock value by the amount added to cart
     * @param amount
     * @throws Exception for when the amount is over the remaining stock, reduce amount
     */
    public void addToCart(int amount) throws Exception { 
        if (this.stock - amount >= 0)
            this.stock -= amount;
        else
            throw new Exception("Product out of stock! Reduce amount");
    }

    /** When called increments the stock value by the amount removed from cart
     * @param amount
     * @throws Exception for when the amount is over the initial stock, reduce amount
     */
    public void removeFromCart(int amount) throws Exception { 
        if (this.stock + amount <= 40)
            this.stock += amount;
        else
            throw new Exception("You are returning over the initial stock!");
    }
}