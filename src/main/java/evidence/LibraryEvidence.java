package evidence;

import model.Book;

import java.util.*;

public class LibraryEvidence {

    private List<Book> availableBookList = new ArrayList<>();
    private List<Book> lentBookList = new ArrayList<>();
    private int nextBookId = 0;


    private int getNextBookId() {
        this.nextBookId++;
        return nextBookId;
    }

    public void addNewBookToLibrary(String title, int year, String author) {
        final int bookId = this.getNextBookId();
        final Book book = new Book(bookId, title, year, author);
        this.availableBookList.add(book);
    }

    public void removeBookFromLibrary(int id) {
        Iterator<Book> index = availableBookList.iterator();
        while (index.hasNext()) {
            Book book = index.next();
            if (book.getId() == id) {
                index.remove();
            }
        }
    }

    public void listAllBooksInLibrary() {
        StringBuilder sb = new StringBuilder();
        sb.append("LIBRARY BOOK LIST:\n");
        List<Book> bookList = this.getAllBooksInLibrary();
        for (int index = 0; index < bookList.size(); index++) {
            Book book = bookList.get(index);
            sb.append("Book " + (index + 1) + ":\n\tid: " + book.getId() + "," + "\n\ttitle: " + book.getTitle() + ",\n\tauthor: " + book.getAuthor());
            sb.append(",\n\tavailable: ");
            if (availableBookList.contains(book)) {
                sb.append("yes");
            } else {
                sb.append("no");
            }
        }
        sb.append("\nSUMMARY:\n- available book count: " + this.availableBookList.size() + "\n- lent book count: " + this.lentBookList.size());
        System.out.println(sb.toString());
    }

    private List<Book> getAllBooksInLibrary() {
        List<Book> bookList = new ArrayList<>();
        bookList.addAll(this.availableBookList);
        bookList.addAll(this.lentBookList);
        return bookList;
    }



}
