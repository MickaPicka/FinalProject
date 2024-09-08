import java.util.List;

public class Reader {
    private int id;
    private String name;
    private List<String> books;

    public Reader(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Reader(int id, String name, List<String> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

    public void readBook(String title) {
        books.add(title);
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books;
    }
}
