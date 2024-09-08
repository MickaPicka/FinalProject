import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shelf {

    private List<Book> books = new ArrayList<>();
    private boolean isShelfFull;

    public Shelf() {}

    public Shelf(List<Book> books, boolean isShelfFull) {
        this.books = books;
        this.isShelfFull = isShelfFull;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public boolean getIsShelfFull() {
        return isShelfFull;
    }

    public void setShelfFull(boolean shelfFull) {
        isShelfFull = shelfFull;
    }

    public void addBook(Book book) {
        if (books.size() == 5 || isShelfFull)
            System.out.println("Shelf is full, cannot add book");
        else {
            books.add(book);
            System.out.println("Book added to shelf successfully");
            if (books.size() == 5) {
                isShelfFull = true;
                System.out.println("Shelf is full");
            }
        }
    }

    public void replaceBooks(int book1,int book2) {
        if (book1 >= books.size() || book2 >= books.size())
            System.out.println("Books index not found");
        else {
            Collections.swap(books, book1, book2);
            System.out.println("Books swapped successfully");
        }
    }

    @Override
    public String toString() {
        return  "books=" + books +
                ", isShelfFull=" + isShelfFull;
    }
}
