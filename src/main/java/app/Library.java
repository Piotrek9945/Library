package app;

import model.Book;
import model.Borrow;

import java.util.*;

public class Library {

    private List<Book> bookList = new ArrayList<>();
    private List<Borrow> borrowList = new ArrayList<>();
    private static int nextBookId = 0;


    private int getNextBookId() {
        this.nextBookId++;
        return nextBookId;
    }

    public Book addNewBookToLibrary(String title, int year, String author) {
        final int bookId = this.getNextBookId();
        final Book book = new Book(bookId, title, year, author);
        this.bookList.add(book);
        return book;
    }

    public boolean removeBookFromLibrary(int id) {
        Iterator<Book> index = this.bookList.iterator();
        while (index.hasNext()) {
            Book book = index.next();
            if (book.getId() == id && this.getBorrowByBookId(book.getId()) == null) {
                index.remove();
                return true;
            }
        }
        return false;
    }

    public Borrow lendBook(int id, String borrowerName) {
        Book book = getBookById(id);
        boolean isLent = isBookLent(id);
        if (book != null && isLent == false) {
            Borrow borrow = new Borrow(id, borrowerName);
            this.borrowList.add(borrow);
        }
        return null;
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


    /**
     * Only one any parameter is required. Other parameters are optional and should be set null.
     * Passing several parameters, result will be given with the conjunction of parameters.
     *
     * @param title
     * @param year
     * @param author
     */
    public Book searchBook(String title, Integer year, String author) {
        if (title == null && year == null && author == null) {
            return null;
        }
        for (Book book : this.bookList) {
            if (title != null && !title.equals(book.getTitle())) {
                continue;
            }
            if (year != null && !year.equals(book.getYear())) {
                continue;
            }
            if (author != null && !author.equals(book.getAuthor())) {
                continue;
            }
            return book;
        }
        return null;
    }
}
