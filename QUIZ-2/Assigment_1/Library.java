import java.util.ArrayList;
import java.util.Iterator;

public class Library {
    // Add the missing implementation to this class
    ArrayList<Book> books;
    public Library(){
        this.books = new ArrayList<>();
    }
    public void addBook(Book book){
        this.books.add(book);
    }
    public void borrowBook(String title){
        if (books.size() > 0 ) {
            for (int i = 0; i<books.size(); i++){
                if (this.books.get(i).getTitle().equals(title)){
                    this.books.remove(this.books.get(i));
                }else {
                    System.out.println("This book is already borrowed.");
                }
            }
        }
    }
    public void returnBook(String title){
        this.books.add(new Book(title));
    }
    public void printAvailableBooks(){
        Iterator<Book> iterator = books.iterator();
        if (books.size()>0){
            while(iterator.hasNext()){
                System.out.println(iterator.next().getTitle());
            }
        }else {
            System.out.println("No book in catalog");
        }
    }
    public static void main(String[] args) {
        Library firstLibrary = new Library();
        Library secondLibrary = new Library();
        // Add four books to the first library
        firstLibrary.addBook(new Book("The Pragmatic Programmer"));
        firstLibrary.addBook(new Book("Code - The Hidden Language"));
        firstLibrary.addBook(new Book("Programming Pearls"));
        firstLibrary.addBook(new Book("Domain Driven Design in Life"));


        // Try to borrow The Pragmatic Programmer from both libraries
        System.out.println("Borrowing The Pragmatic Programmer:");
        firstLibrary.borrowBook("The Pragmatic Programmer");
        firstLibrary.borrowBook("The Pragmatic Programmer");
        secondLibrary.borrowBook("The Pragmatic Programmer");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return TThe Pragmatic Programmer to the first library
        System.out.println("Returning The Pragmatic Programmer:");
        firstLibrary.returnBook("The Pragmatic Programmer");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}
