package Iterator;

public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("A"));
        bookShelf.appendBook(new Book("B"));
        bookShelf.appendBook(new Book("C"));
        bookShelf.appendBook(new Book("D"));
        Iterator it =  bookShelf.iterator();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            System.out.println(book.getName());
        }
    }
}
