import com.ecommerce.Product;
import com.ecommerce.Customer;
import com.ecommerce.orders.Order;

public class Assignment2 {
    public static void main(String[] args) throws Exception {
        Product item1 = new Product("2911204", "iPhone 16", 799);
        Product item2 = new Product("2911205", "iPhone 16 Pro", 999);
        Product item3 = new Product("2911206", "iPhone 16 Pro Max", 1199);

        Customer user1 = new Customer("18tp21653", "Bolang-Lonson");
        user1.addProduct(item1, 3);
        user1.addProduct(item2, 2);
        user1.addProduct(item3, 1);

        Order checkout = new Order("Ord1", user1, false);

        System.out.println("\nThe total of the order is: " + checkout.getOrderTotal());
        System.out.println();
        checkout.getSummary();
        System.out.println();

        user1.removeProduct(item1, 1);

        System.out.printf("\nAfter removing 1 %s from the cart, the new total is: %n %n", item1.toString());
        checkout.getSummary();

        // Paying for order
        checkout.setStatus(true);
        if(checkout.getStatus())
            System.out.println("\nOrder payment completed!");
        else
            System.out.println("\nOrder payment not completed");
    }
}