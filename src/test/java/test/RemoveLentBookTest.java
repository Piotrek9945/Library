package test;

import app.Library;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RemoveLentBookTest {

    Library tester = new Library();
    int bookId = 0;

    @Before
    public void addNewBook() {
        this.bookId = tester.addNewBookToLibrary("test dsa", 123, "bgfdbb").getId();
        tester.lendBook(this.bookId, "asd");
    }

    @Test
    public void removeLentBookShouldReturnFalse() {
        assertFalse(tester.removeBookFromLibrary(this.bookId));
    }



}
