public class Book {
    private String title;
    private String author;
    private double price;


    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        setPrice(price); 
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Book price cannot be negative.");
        }
        this.price = price;
    }

    
    public void displayBook(int index) {
        System.out.printf("%-5d | %-32s | %-20s | $%-7.2f\n", index, title, author, price);
    }
}