import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookstoreManager manager = new BookstoreManager();

        System.out.println("======================================================================");
        System.out.println("       WELCOME TO THE BOOKSTORE MANAGEMENT SYSTEM     ");
        System.out.println("======================================================================");

        System.out.print("\nPlease enter the customer's name: ");
        String customerName = scanner.nextLine().trim();

        while (customerName.isEmpty()) {
            System.out.print("Oops! Customer name is missing. Please enter it: ");
            customerName = scanner.nextLine().trim();
        }

        Customer customer = new Customer(101, customerName);
        Purchase purchase = new Purchase((int)(1000 + Math.random() * 9000), customer);

        boolean keepShopping = true;
        while (keepShopping) {
            manager.displayInventory();
            System.out.print("\nEnter the Book ID you wish to purchase (1 - " 
            + manager.getInventorySize() + ") or enter '0' when your book selection is complete: ");

            if (scanner.hasNextInt()) {
                int selection = scanner.nextInt();
                scanner.nextLine(); // Clear buffer

                if (selection == 0) {
                    keepShopping = false;
                } else if (selection > 0 && selection <= manager.getInventorySize()) {
                    Book selectedBook = manager.getBookByIndex(selection - 1);
                    purchase.addBook(selectedBook);
                } else {
                    System.out.println("[ERROR] Invalid selection! Please enter a number between 1 and " + manager.getInventorySize() + ".");
                }
            } else {
                System.out.println("[ERROR] Book selection failed. Enter a valid ID from the available list.");
                scanner.nextLine(); // Clear invalid token buffer
            }
        }

        if (!purchase.getPurchasedBooks().isEmpty()) {
            Invoice invoice = purchase.generateInvoice(); 
            invoice.printInvoice();                       
        } else {
            System.out.println("\n[NOTICE] No books were selected for purchase. Checkout has been cancelled.");
        }

        System.out.println("\n======================================================================");
        System.out.println("Thank you for visiting our bookstore. We wish you a great reading journey. Goodbye!");
        System.out.println("======================================================================");

        scanner.close();
    }
}