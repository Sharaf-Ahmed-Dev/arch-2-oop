import java.util.List;

public class Invoice {
    private int invoiceId;
    private Customer customer;
    private List<Book> books;
    private double totalAmount;

    public Invoice(int invoiceId, Customer customer, List<Book> books, double totalAmount) {
        this.invoiceId = invoiceId;
        this.customer = customer;
        this.books = books;
        this.totalAmount = totalAmount;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void printInvoice() {
        System.out.println("\n======================================================================");
        System.out.println("                         BOOKSTORE TRANSACTION INVOICE                    ");
        System.out.println("======================================================================");
        System.out.println(" Customer Name : " + customer.getName() + " (ID: " + customer.getCustomerId() + ")");
        System.out.println(" Transaction ID: BK-TXN-" + (1000 + (int) (Math.random() * 9000)));
        System.out.println("----------------------------------------------------------------------");
        System.out.println(" PURCHASED ITEMS:");
        System.out.printf(" %-5s | %-45s | %-8s\n", "#", "Book Title", "Price ($)");
        System.out.println("----------------------------------------------------------------------");

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            System.out.printf(" %-5d | %-45s | $%-7.2f\n", (i + 1), book.getTitle(), book.getPrice());
        }

        System.out.println("----------------------------------------------------------------------");
        System.out.printf(" TOTAL PURCHASE AMOUNT:                                    $%.2f\n", totalAmount);
        System.out.println("======================================================================");
    }
}

