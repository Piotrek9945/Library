package test;

import app.Library;
import model.Book;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class RemoveBookTest {

    Library tester = new Library();
    Book book;

    @Before
    public void addNewBook() {
        book = tester.addNewBookToLibrary("test dsa", 123, "bgfdbb");
    }

    @Test
    public void removeBookFromLibraryShouldRemoveABookFromBookList() {
        int bookId = book.getId();
        tester.removeBookFromLibrary(bookId);
        Book bookFromList = tester.findBookInBookListById(bookId);
        assertThat(bookFromList, equalTo(null));
    }

}
