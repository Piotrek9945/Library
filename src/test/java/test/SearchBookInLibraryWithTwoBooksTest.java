package test;

import app.Library;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchBookInLibraryWithTwoBooksTest {

    Library tester = new Library();

    @Before
    public void addNewBook() {
        tester.addNewBookToLibrary("test", 123, "bbb");
        tester.addNewBookToLibrary("asd", 13, "bbbaaa");
    }

    @Test
    public void searchBookInLibraryWithAllParametersGivenShouldReturnBookWithCorrectAuthorAttributeValue() {
        assertEquals("bbb", tester.searchBook("test", 123, "bbb").getAuthor());
    }

    @Test
    public void searchBookInLibraryWithTwoParametersGivenShouldReturnBookWithCorrectAuthorAttributeValue() {
        assertEquals("bbb", tester.searchBook("test", null, "bbb").getAuthor());
    }

    @Test
    public void searchBookInLibraryWithOneParameterGivenShouldReturnBookWithCorrectAuthorAttributeValue() {
        assertEquals("bbb", tester.searchBook(null, null, "bbb").getAuthor());
    }

    @Test(expected = NullPointerException.class)
    public void searchBookInLibraryWithOneMistakeInAuthorShouldReturnNullPointerException() {
        assertEquals("bbb", tester.searchBook(null, 0, "bbbb").getAuthor());
    }

    @Test(expected = NullPointerException.class)
    public void searchBookInLibraryWithOneMistakeInTitleShouldReturnNullPointerException() {
        assertEquals("bbb", tester.searchBook("subbb", 123, "bbb").getAuthor());
    }

}
