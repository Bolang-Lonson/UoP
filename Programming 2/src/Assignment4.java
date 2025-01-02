import java.util.ArrayList;
import java.util.Scanner;

class Catalog<T> {
    private ArrayList<T> items;

    public Catalog() {
        items = new ArrayList<>();
    }

    // Add item to the catalog
    public void addItem(T item) {
        items.add(item);
        System.out.println(item + " added to the catalog.");
    }

    // Remove item from the catalog
    public boolean removeItem(T item) {
        if (items.remove(item)) {
            System.out.println(item + " removed from the catalog.");
            return true;
        } else {
            System.out.println("Item not found.");
            return false;
        }
    }

    // Retrieve item details
    public void viewCatalog() {
        if (items.isEmpty()) {
            System.out.println("Catalog is empty.");
        } else {
            System.out.println("Catalog Contents:");
            for (T item : items) {
                System.out.println(item);
            }
        }
    }

    public ArrayList<T> getItems() {
        return this.items;
    }
}

class LibraryItem {
    private String title;
    private String author;
    private String itemID;

    public LibraryItem(String title, String author, String itemID) {
        this.title = title;
        this.author = author;
        this.itemID = itemID;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getItemID() {
        return itemID;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Item ID: " + itemID;
    }
}

public class Assignment4 {
    public static void main(String[] args) {
        Catalog<LibraryItem> catalog = new Catalog<>();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nLibrary Catalog");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. View Catalog");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume the newline

            if (choice == 1) {
                System.out.print("Enter title: ");
                String title = scanner.nextLine();
                System.out.print("Enter author: ");
                String author = scanner.nextLine();
                System.out.print("Enter item ID: ");
                String itemID = scanner.nextLine();

                LibraryItem newItem = new LibraryItem(title, author, itemID);
                catalog.addItem(newItem);
            } else if (choice == 2) {
                System.out.print("Enter item ID to remove: ");
                String itemID = scanner.nextLine();
                // Here we would search by itemID, but for simplicity, we'll remove by title
                LibraryItem itemToRemove = null;
                for (LibraryItem item : catalog.getItems()) {
                    if (item.getItemID().equals(itemID)) {
                        itemToRemove = item;
                        break;
                    }
                }
                if (itemToRemove != null) {
                    catalog.removeItem(itemToRemove);
                } else {
                    System.out.println("Item not found.");
                }
            } else if (choice == 3) {
                catalog.viewCatalog();
            } else if (choice == 4) {
                break;
            }
        }

        scanner.close();
    }
}

class TestLibraryCatalog {
    public static void main(String[] args) {
        Catalog<LibraryItem> catalog = new Catalog<>();
        
        LibraryItem book = new LibraryItem("Java Basics", "John Doe", "001");
        LibraryItem dvd = new LibraryItem("Java Programming DVD", "Jane Smith", "002");
        LibraryItem magazine = new LibraryItem("Tech Today", "Tom Brown", "003");

        catalog.addItem(book);
        catalog.addItem(dvd);
        catalog.addItem(magazine);
        
        catalog.viewCatalog();

        catalog.removeItem(book);
        catalog.viewCatalog();
    }
}