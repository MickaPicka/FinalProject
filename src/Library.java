import java.util.*;

public class Library {
    private List<Shelf> shelves;
    private List<Reader> readers = new ArrayList<>();

    public Library(List<Shelf> shelves) {
        this.shelves = shelves;
    }

    public Library(List<Shelf> shelves, List<Reader> readers) {
        this.shelves = shelves;
        this.readers = readers;
    }

    public List<Shelf> getShelves() {
        return shelves;
    }

    public void setShelves(List<Shelf> shelves) {
        this.shelves = shelves;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }

    public boolean isTherePlaceForNewBook() {
        return !shelves.get(0).getIsShelfFull() || !shelves.get(1).getIsShelfFull() || !shelves.get(2).getIsShelfFull();
    }

    public void addNewBook(Book book) {
        if (isTherePlaceForNewBook())
            for (int i = 0; i < 3; i++)
                if (!shelves.get(i).getIsShelfFull()) {
                    shelves.get(i).addBook(book);
                    break;
                }
    }

    public void deleteBook(String title) {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < shelves.size(); i++) {
            books = shelves.get(i).getBooks();
            for (int j = 0; j < books.size(); j++) {
                if (books.get(j).getTitle().equals(title)) {
                    books.remove(j);
                    shelves.get(i).setBooks(books);
                    shelves.get(i).setShelfFull(false);
//                    shelves.get(i).getBooks().remove(j);
//                    shelves.get(i).setShelfFull(false);
                    System.out.println("Book deleted successfully");
                    break;
                }
            }
        }
    }

    public void registerReader(String name, int id) {
        readers.add(new Reader(id, name));
        System.out.println("Reader added successfully");
    }

    public void removeReader(String name) {
        for (int i = 0; i < readers.size(); i++)
            if (readers.get(i).getName().equals(name)) {
                readers.remove(i);
                System.out.println("Reader removed successfully");
                break;
            }
    }

    public List<String> searchByAuthor(String authorName) {
        List<String> booksTitle = new ArrayList<>();
        for (Shelf shelf : shelves)
            for (Book book : shelf.getBooks())
                if (book.getAuthor().equals(authorName))
                    booksTitle.add(book.getTitle());
//        Set<String> set = new HashSet<>(booksTitle);
//        booksTitle.clear(); // remove duplicate books
//        booksTitle.addAll(set);
        return booksTitle;
    }

    @Override
    public String toString() {
        return  "shelves=" + shelves +
                ", readers=" + readers;
    }
}
