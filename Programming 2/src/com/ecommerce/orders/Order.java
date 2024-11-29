package com.ecommerce.orders;

import java.util.ArrayList;

import com.ecommerce.*;

/** This class represents an order placed by a customer. Include attributes like orderID, customer, products, and the order total. 
 * Implement methods to generate order summaries, update order status, and manage order information.   
 */
public class Order {

    private final String orderID;
    private Customer customer;

    /** <b><em>ArrayList</em></b> of products a customer ordered*/
    private ArrayList<Product> products;

    /** Total price of all products customer ordered */
    private double orderTotal;

    /** Boolean. <b>true</b> if paid for and <b>false</b> if unpaid for */
    private boolean isPaid;

    /**
     * Initializes an object representing an order
     * @param ID
     * @param customer
     */
    public Order(String ID, Customer customer, boolean paid) {
        this.orderID = ID;
        this.customer = customer;

        this.products = customer.shoppingCart;

        double tot = 0;
        for(Product pdt: products) {
            tot += pdt.getPrice();
        }
        this.orderTotal = tot;

        this.isPaid = paid;
    }

    /** Returns order ID */
    public String getId() { return this.orderID; }

    /** Gets status of whether order has been paid for */
    public boolean getStatus() { return this.isPaid; }

    /** Prints a receipt-like list of all products and their prices in the order */
    public void getSummary() {
        this.products = this.customer.shoppingCart;

        double tot = 0;
        for(Product pdt: products) {
            tot += pdt.getPrice();
        }
        this.orderTotal = tot;

        System.out.println("Order summary for: " + this.customer);

        for(Product pdt: products) {
            System.out.println(pdt.toString() + "\t\t\t\t" + pdt.getPrice());
        }
        System.out.println("The order total: \t\t" + this.orderTotal);
    }

    /** Takes boolean value and sets the paid status */
    public void setStatus(boolean paid) { this.isPaid = paid; }

    /** Returns the total of order */
    public double getOrderTotal() { return this.orderTotal; }

}