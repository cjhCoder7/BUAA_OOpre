import java.util.ArrayList;
import java.util.Iterator;

public class BookShelf {
    private final int id;
    private final ArrayList<Book> books;

    public BookShelf(int id) {
        this.id = id;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public BookShelf cloneBookshelf() {
        BookShelf clone = new BookShelf(id);
        for (Book book : books) {
            clone.addBook(book.clone());
        }
        return clone;
    }

    public void filter(int num) {
        for (Iterator<Book> iterator = books.iterator(); iterator.hasNext(); ) {
            Book book = iterator.next();
            if (book.getScore() < num) {
                iterator.remove();
            }
        }
    }

    public void join(BookShelf bookShelf) {
        for (Book book : bookShelf.books) {
            boolean hasBook = false;
            for (Book book1 : books) {
                if (book1.equals(book)) {
                    hasBook = true;
                    break;
                }
            }
            if (!hasBook) {
                books.add(book);
            }
        }
    }

    public void addMagic(String magic) {
        for (Book book : books) {
            book.addMagic(magic);
        }
    }

    public void subMagic(int a, int b) {
        for (Book book : books) {
            book.subMagic(a, b);
        }
    }

    public int getNum1() {
        return books.size();
    }

    public int getNum2(String s) {
        int res = 0;
        for (Book book : books) {
            if (book.contains(s)) {
                res++;
            }
        }
        return res;
    }
}
