package test;

import app.Library;
import model.Book;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.assertThat;

public class SearchBookInLibraryTest {

    Library tester = new Library();
    Book book;

    @Before
    public void addNewBook() {
        book = tester.addNewBookToLibrary("test", 123, "bbb");
    }

    @Test
    public void searchBookInLibraryWithAllParametersGivenShouldReturnBookWithCorrectAuthorAttributeValue() {
        Book searchBook = tester.searchBook("test", 123, "bbb");
        assertThat(this.book, sameInstance(searchBook));
    }

    @Test
    public void searchBookInLibraryWithTwoParametersGivenShouldReturnBookWithCorrectAuthorAttributeValue() {
        Book searchBook = tester.searchBook("test", null, "bbb");
        assertThat(this.book, sameInstance(searchBook));
    }

    @Test
    public void searchBookInLibraryWithOneParameterGivenShouldReturnBookWithCorrectAuthorAttributeValue() {
        Book searchBook = tester.searchBook(null, null, "bbb");
        assertThat(this.book, sameInstance(searchBook));
    }

    @Test
    public void searchBookInLibraryWithOneMistakeInAuthorShouldReturnNullPointerException() {
        Book searchBook = tester.searchBook(null, null, "bbbbb");
        assertThat(searchBook, equalTo(null));
    }
}
