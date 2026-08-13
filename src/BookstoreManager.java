import java.util.ArrayList;
import java.util.List;

public class BookstoreManager {
    private List<Book> inventory;

    public BookstoreManager() {
        this.inventory = new ArrayList<>();
        initializeInventory();
    }

    private void initializeInventory() {
        // Fiction & Sci-Fi
        addBook(new Book("To Kill a Mockingbird", "Harper Lee", 18.99));
        addBook(new Book("1984", "George Orwell", 15.50));
        addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 12.75));
        addBook(new Book("Dune", "Frank Herbert", 22.00));

        // Self-Help & Psychology
        addBook(new Book("Atomic Habits", "James Clear", 27.00));
        addBook(new Book("The Psychology of Money", "Morgan Housel", 20.50));
        addBook(new Book("Thinking, Fast and Slow", "Daniel Kahneman", 24.99));

        // History & Non-Fiction
        addBook(new Book("Sapiens: A Brief History of Humankind", "Yuval Noah Harari", 28.50));
        addBook(new Book("Astrophysics for People in a Hurry", "Neil deGrasse Tyson", 16.80));
        addBook(new Book("Educated", "Tara Westover", 19.99));

        // Biography & Business
        addBook(new Book("Steve Jobs", "Walter Isaacson", 32.00));
        addBook(new Book("Shoe Dog", "Phil Knight", 21.40));

        // Technology
        addBook(new Book("Clean Code", "Robert C. Martin", 45.99));
        addBook(new Book("Design Patterns", "Erich Gamma", 54.50));
        addBook(new Book("Head First Java", "Kathy Sierra", 42.80));
    }

    public void addBook(Book book) {
        if (book != null) {
            inventory.add(book);
        }
    }

    public void removeBook(Book book) {
        inventory.remove(book);
    }

    public Book getBookByIndex(int index) {
        if (index >= 0 && index < inventory.size()) {
            return inventory.get(index);
        }
        return null;
    }

    public int getInventorySize() {
        return inventory.size();
    }

    public void displayInventory() {
        System.out.println("\n----------------------------------------------------------------------");
        System.out.println("                        AVAILABLE BOOK COLLECTION                     ");
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("%-5s | %-32s | %-20s | %-8s\n", "ID", "Book Title", "Author", "Price ($)");
        System.out.println("----------------------------------------------------------------------");

        for (int i = 0; i < inventory.size(); i++) {
            inventory.get(i).displayBook(i + 1);
        }
        System.out.println("----------------------------------------------------------------------");
    }
}