package Iterator;

/**
 * 用于遍历书架的 BookShelfIterator 类
 * 该接口要发挥 Iterator 的作用，因此要实现 Iterator接口
 */
public class BookShelfIterator implements Iterator {
    // 要遍历的书架
    private BookShelf bookShelf;
    private int index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    public boolean hasNext() {
        if (index < bookShelf.getLength()) {
            return true;
        }
        return false;
    }

    public Object next() {
        Book book = bookShelf.getBookAt(index++);
        return book;
    }
}
