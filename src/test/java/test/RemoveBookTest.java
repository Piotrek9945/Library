package test;

import app.Library;
import model.Book;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RemoveBookTest {

    Library tester = new Library();
    int bookId = 0;

    @Before
    public void addNewBook() {
        Book book = tester.addNewBookToLibrary("test dsa", 123, "bgfdbb");
        this.bookId = book.getId();
    }

    @Test
    public void removeBookShouldReturnTrue() {
        assertTrue(tester.removeBookFromLibrary(this.bookId));
    }

}
