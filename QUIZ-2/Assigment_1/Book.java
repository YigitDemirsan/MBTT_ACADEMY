import java.util.ArrayList;
import java.util.Scanner;

public class Book {
    ArrayList<String> bookList;
    String title;
    boolean borrowed;

    // Creates a new Book
    public Book(String bookTitle) {
        // Implement this method
        bookList = new ArrayList<>();
        this.title = bookTitle;
        this.borrowed = false;
        bookList.add(this.title);
    }
    // Marks the book as rented
    public void borrowed() {
        // Implement this method
        bookList.remove(bookList.size()-1);
    }

    // Marks the book as not rented
    public void returned() {
        // Implement this method
        bookList.add(this.getTitle());
        this.borrowed = false;
    }

    // Returns true if the book is rented, false otherwise
    public boolean isBorrowed() {
        // Implement this method
        return this.borrowed;
    }

    // Returns the title of the book
    public String getTitle() {
        // Implement this method
        return this.title;
    }
    public void rented(){
        for(int i = 0; i<bookList.size(); i++){
            System.out.println("Rentable books are listed:"+"\n"+(i+1)+") "+this.bookList.get(i));
            Scanner scanner = new Scanner(System.in);
            System.out.println("Which book wou want to rent:");
            int index = scanner.nextInt();
            bookList.remove(bookList.get(index-1));
            this.borrowed = true;
        }
    }
    public static void main(String[] arguments) {
        // Small test of the Book class
        Book example = new Book("The Pragmatic Programmer");
        System.out.println("Title (should be The Pragmatic Programmer): " + example.getTitle());
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
        example.rented();
        System.out.println("Borrowed? (should be true): " + example.isBorrowed());
        example.returned();
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
    }
} 
