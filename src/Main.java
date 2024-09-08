import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = getLibrary();

        String author;
        String title;
        int numOfPages;
        String name;
        int id;
        Scanner scanner = new Scanner(System.in);
        int menuChoice = 0;
        System.out.println("Welcome to the library");
        while (menuChoice != 6) {
            //System.out.println(library);//
            menu();
            menuChoice = scanner.nextInt();
            scanner.nextLine();
            switch (menuChoice) {
                case 1 :
                    System.out.println("Enter author name, title and number of pages");
                    author = scanner.nextLine();
                    title = scanner.nextLine();
                    numOfPages = scanner.nextInt();
                    library.addNewBook(new Book(author, title, numOfPages));
                    break;
                case 2:
                    System.out.println("Enter book title");
                    title = scanner.nextLine();
                    library.deleteBook(title);
                    break;
                case 3:
                    System.out.println("Enter reader name and id");
                    name = scanner.nextLine();
                    id = scanner.nextInt();
                    library.registerReader(name, id);
                    break;
                case 4:
                    System.out.println("Enter reader name");
                    name = scanner.nextLine();
                    library.removeReader(name);
                    break;
                case 5:
                    System.out.println("Enter author name");
                    name = scanner.nextLine();
                    System.out.println(library.searchByAuthor(name));
                    break;
                case 6:
                    System.out.println("Bye");
                    break;
                default:
                    break;
            }
        }
    }

    private static Library getLibrary() {
        Book book1 = new Book("AAA", "aaa", 10);
        Book book2 = new Book("BBB", "bbb", 20);
        Book book3 = new Book("CCC", "ccc", 15);
        Book book4 = new Book("AAA", "ddd", 25);
        Book book5 = new Book("EEE", "eee", 11);
        Book book6 = new Book("AAA", "fff", 22);

        ArrayList<Book> books1 = new ArrayList<>();
        books1.add(book1);
        books1.add(book2);
        Shelf shelf1 = new Shelf(books1, false);

        ArrayList<Book> books2 = new ArrayList<>();
        books2.add(0, book3);
        books2.add(1, book4);
        Shelf shelf2 = new Shelf(books2, false);

        ArrayList<Book> books3 = new ArrayList<>();
        books3.add(0, book5);
        books3.add(1, book6);
        Shelf shelf3 = new Shelf(books3, false);

        ArrayList<Shelf> shelves = new ArrayList<>();
        shelves.add(shelf1);
        shelves.add(shelf2);
        shelves.add(shelf3);
        return new Library(shelves);
    }

    public static void menu() {
        System.out.println("""
                        1>\tFor adding a book.
                        2>\tFor deleting a book.
                        3>\tFor registering a new reader.
                        4>\tFor removing a reader.
                        5>\tFor searching books by author.
                        6>\tFor exit""");
    }
}
