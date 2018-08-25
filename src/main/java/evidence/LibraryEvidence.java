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

    public void lendBook(int id, String borrowerName) {
        Book book = getBookById(id);
        boolean isLent = isBookLent(id);
        if (book != null && isLent == false) {
            Borrow borrow = new Borrow(id, borrowerName);
            this.borrowList.add(borrow);
        }
    }

    private Book getBookById(int id) {
        Book book = null;
        for (Book item : this.bookList) {
            if (item.getId() == id) {
                book = item;
            }
        }
        return book;
    }

    private boolean isBookLent(int id) {
        boolean isLent = false;
        if (this.getBorrowByBookId(id) != null) {
            isLent = true;
        }
        return isLent;
    }

    private Borrow getBorrowByBookId(int id) {
        for (Borrow item : this.borrowList) {
            if (item.getBookId() == id) {
                return item;
            }
        }
        return null;
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
            if (this.getBorrowByBookId(book.getId()) == null) {
                sb.append("yes");
            } else {
                sb.append("no");
            }
            sb.append("\n");
        }
        sb.append("SUMMARY:\n- available book count: " + bookAvailableCount + "\n- lent book count: " + bookBorrowedCount);
        System.out.println(sb.toString());
    }

    public void listBookDetailsById(int id) {
        StringBuilder sb = new StringBuilder();
        sb.append("THE BOOK DETAILS:");
        Book book = this.getBookById(id);
        sb.append("\n\tid: " + book.getId() + "," + "\n\ttitle: " + book.getTitle() + ",\n\tauthor: " + book.getAuthor());
        sb.append(",\n\tavailable: ");
        Borrow borrow = this.getBorrowByBookId(book.getId());
        if (borrow == null) {
            sb.append("yes");
        } else {
            sb.append("no");
            sb.append(",\n\tborrower name: " + borrow.getBorrowerName());
        }
        System.out.println(sb.toString());
    }
}
