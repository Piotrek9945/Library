package test;

import app.Library;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LendBookTest {

    Library tester = new Library();

    @Before
    public void addNewBook() {
        tester.addNewBookToLibrary("test", 123, "bbb");
        tester.lendBook(1, "asd");
    }

    @Test
    public void borrowLentBookShouldReturnNull() {
        assertNull(tester.lendBook(1, "sdf"));
    }

    @Test
    public void borrowLentBookToTheSameBorrowerShouldReturnNull() {
        assertNull(tester.lendBook(1, "bbb"));
    }

    @Test
    public void borrowNotExistingBookShouldReturnNull() {
        assertNull(tester.lendBook(5, "bbb"));
    }

}
