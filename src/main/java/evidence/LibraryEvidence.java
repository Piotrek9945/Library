package evidence;

import model.Book;
import model.Borrow;

import java.util.*;

public class LibraryEvidence {

    private List<Book> bookList = new ArrayList<>();
    private List<Borrow> borrowList = new ArrayList<>();
    private int nextBookId = 0;


    private int getNextBookId() {
        this.nextBookId++;
        return nextBookId;
    }

    public void addNewBookToLibrary(String title, int year, String author) {
        final int bookId = this.getNextBookId();
        final Book book = new Book(bookId, title, year, author);
        this.bookList.add(book);
    }

    public void removeBookFromLibrary(int id) {
        Iterator<Book> index = this.bookList.iterator();
        while (index.hasNext()) {
            Book book = index.next();
            if (book.getId() == id && !this.borrowList.contains(book)) {
                index.remove();
            }
        }
    }

    public void listLibraryBookList() {
        int bookCount = this.bookList.size();
        int bookBorrowedCount = this.borrowList.size();
        int bookAvailableCount = bookCount - bookBorrowedCount;
        StringBuilder sb = new StringBuilder();
        sb.append("LIBRARY BOOK LIST:\n");
        for (int index = 0; index < bookCount; index++) {
            Book book = this.bookList.get(index);
            sb.append("Book " + (index + 1) + ":\n\tid: " + book.getId() + "," + "\n\ttitle: " + book.getTitle() + ",\n\tauthor: " + book.getAuthor());
            sb.append(",\n\tavailable: ");
            if (this.borrowList.contains(book)) {
                sb.append("no");
            } else {
                sb.append("yes");
            }
        }
        sb.append("\nSUMMARY:\n- available book count: " + bookAvailableCount + "\n- lent book count: " + bookBorrowedCount);
        System.out.println(sb.toString());
    }

}
