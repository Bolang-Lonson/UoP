import java.util.HashMap;

class Book {
    String title;
    String author;
    int quantity;
    int borrowed;
  
    public Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.borrowed = 0;
    }
  
    public boolean borrow() {
        if (quantity > borrowed) {
            borrowed++;
            return true;
        } else {
            return false;
        }
    }
  
    public boolean returnBook() {
        if (borrowed > 0) {
            borrowed--;
            return true;
        } else {
            return false;
        }
    }
}
  
class Library {
    HashMap<String, Book> books;
  
    public Library() {
        this.books = new HashMap<>();
    }
  
    public void addBook(String title, String author, int quantity) {
        if (books.containsKey(title)) {
            books.get(title).quantity += quantity;
        } else {
            books.put(title, new Book(title, author, quantity));
        }
    }
  
    public boolean borrowBook(String title) {
        if (books.containsKey(title)) {
            if (books.get(title).borrow()) {
                System.out.println("Successfully borrowed " + title);
                return true;
            } else {
                System.out.println("Sorry, " + title + " is not available");
                return false;
            }
        } else {
            System.out.println("Sorry, we don't have the book " + title);
            return false;
        }
    }
  
    public boolean returnBook(String title) {
      if (books.containsKey(title)) {
        if (books.get(title).returnBook()) {
            System.out.println("Successfully returned " + title);
            return true;
        } else {
            System.out.println("Sorry, there are no borrowed copies of " + title);
            return false;
        }
      } else {
            System.out.println("Sorry, we don't have the book " + title);
            return false;
      }
    }
}

public class Assignment2 {
    public static void main(String[] args) {
        Library library = new Library();

        // Add some books to the library
        library.addBook("The Lord of the Rings", "J.R.R. Tolkien", 2);
        library.addBook("Pride and Prejudice", "Jane Austen", 1);
        library.addBook("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", 3);

        // Borrow books
        library.borrowBook("The Lord of the Rings");
        library.borrowBook("Pride and Prejudice");
        library.borrowBook("The Hitchhiker's Guide to the Galaxy"); // Not available

        // Return books
        library.returnBook("The Lord of the Rings");
        library.returnBook("Pride and Prejudice"); // Not possible

        // Try borrowing a non-existent book
        library.borrowBook("A Confederacy of Dunces");
    }
}
