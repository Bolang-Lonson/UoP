package com.ecommerce;

import java.util.ArrayList;

/** This class represents a customer with attributes like customerID, name, and a shopping cart. 
 * Implement methods to add and remove products from the shopping cart, calculate the total cost, and place orders. 
 */
public class Customer {

    private final String customerID;
    private String name;
    public ArrayList<Product>  shoppingCart;

    /** Creates instance of Customer object
     * @param ID unique customer ID
     * @param name customer name
     */
    public Customer(String ID, String name) {
        this.customerID = ID;
        this.name = name;

        // Initialising individual shopping cart
        this.shoppingCart = new ArrayList<Product>();
    }

    /** Returns the customer's <b>unique ID</b> */
    public String getId() { return customerID; }

    @Override
    public String toString() { return this.name; }  // Setting what gets printed when printing the object or converting to a string

    /**
     * Method to add a product into the customer's shopping cart
     * @param pdt Product object to be added to cart
     * @param amount amount of the object to be added to cart
     */
    public void addProduct(Product pdt, int amount) {
        try {
            pdt.addToCart(amount);

            for(int i = 1; i <= amount; i++) {
                shoppingCart.add(pdt);
            }

            System.out.println("Item added to cart successfully!");
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method to remove a product into the customer's shopping cart
     * @param pdt Product object to be added to cart
     * @param amount amount of the object to be added to cart
     * <pre>
     * {@code
     *  public void removeProduct(Product pdt, int amount) {
     *      try {
     *          pdt.removeFromCart(amount);
                shoppingCart.remove(pdt);
                System.out.println("Item removed from cart successfully!");
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
     * }
     * </pre>
     */
    public void removeProduct(Product pdt, int amount) {
        try {
            pdt.removeFromCart(amount);

            for(int i = 1; i <= amount; i++) {
                shoppingCart.remove(pdt);
            }

            System.out.println("Item removed from cart successfully!");

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}