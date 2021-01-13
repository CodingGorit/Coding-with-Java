package Iterator;

/**
 * 表示书架的类，改类需要作为集合保存 所有的书籍，因此需要实现 Aggregate 接口
 */
public class BookShelf implements Aggregate {
    private Book[] books;
    private int last = 0;

    public BookShelf(int maxsize) {
        this.books = new Book[maxsize];
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    public void appendBook(Book book) {
        this.books[last] = book;
        last++;
    }

    public int getLength() {
        return last;
    }

    // ps 当外部想要遍历书架时，就会调用这个方法：
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
