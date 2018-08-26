package test;

import app.Library;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AddBookToEmptyLibraryTest {

    Library tester = new Library();

    @Test
    public void addNewBookToLibraryShouldReturnNotNullForAllParametersGiven() {
        assertNotNull("addNewBookToLibrary returns null", tester.addNewBookToLibrary("test", 123, "bbb"));
    }

    @Test
    public void addNewBookToLibraryShouldReturnBookWithNotNullIdAttribute() {
        assertNotNull(tester.addNewBookToLibrary("test", 123, "bbb").getId());
    }

    @Test
    public void addNewBookToLibraryShouldReturnBookWithCorrectTitleAttributeValue() {
        assertEquals("test", tester.addNewBookToLibrary("test", 123, "bbb").getTitle());
    }

    @Test
    public void addNewBookToLibraryShouldReturnBookWithCorrectYearAttributeValue() {
        assertEquals(123, tester.addNewBookToLibrary("test", 123, "bbb").getYear());
    }

    @Test
    public void addNewBookToLibraryShouldReturnBookWithCorrectAuthorAttributeValue() {
        assertEquals("bbb", tester.addNewBookToLibrary("test", 123, "bbb").getAuthor());
    }

    @Test(expected = NullPointerException.class)
    public void searchBookInLibraryWithoutAnyBookShouldReturnNullPointerException() {
        assertEquals("bbb", tester.searchBook("subbb", 123, "bbb").getAuthor());
    }

}
