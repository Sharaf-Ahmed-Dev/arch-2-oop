import java.util.ArrayList;
import java.util.List;

public class Purchase {
    private int purchaseId;
    private Customer customer;
    private List<Book> purchasedBooks;
    private double totalAmount;

    public Purchase(int purchaseId, Customer customer) {
        this.purchaseId = purchaseId;
        this.customer = customer;
        this.purchasedBooks = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    public void addBook(Book book) {
        if (book != null) {
            purchasedBooks.add(book);
            System.out.println("--> SUCCESS: Added \"" + book.getTitle() + "\" ($" + String.format("%.2f", book.getPrice()) + ") to cart.");
        }
    }

    public double calculateTotal() {
        totalAmount = 0.0;
        for (Book book : purchasedBooks) {
            totalAmount += book.getPrice();
        }
        return totalAmount;
    }

    public Invoice generateInvoice() {
        calculateTotal();
        return new Invoice(purchaseId, customer, purchasedBooks, totalAmount);
    }

    public List<Book> getPurchasedBooks() {
        return purchasedBooks;
    }

    public Customer getCustomer() {
        return customer;
    }
}