
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {

        Library myLibrary = new Library();

        myLibrary.addBook(new Book("Dune", "Frank Herbert", 500));
        myLibrary.addBook(new Book("1984", "George Orwell", 300));
        myLibrary.addBook(new Book("The Hobbit", "J.R.R. Tolkien", 350));
        myLibrary.addBook(new Book("Animal Farm", "George Orwell", 150));

        System.out.println("All books:");
        myLibrary.showAllBooks();

        System.out.println("\nBooks by George Orwell:");
        ArrayList<Book> orwellBooks = myLibrary.findBooksByAuthor("George Orwell");
        for (Book b : orwellBooks) {
            System.out.println(b);
        }
    }

}