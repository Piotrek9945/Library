package test;

import app.Library;
import model.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class RemoveBookTest {

    @Parameterized.Parameter(0)
    public String title;

    @Parameterized.Parameter(1)
    public Integer year;

    @Parameterized.Parameter(2)
    public String author;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { "Pan Tadeusz" , 1732, "Adam Mickiewicz" }, { "Kaczor Donald", 1975, "Walt Disney" } };
        return Arrays.asList(data);
    }

    Library tester = new Library();
    Book book;

    @Before
    public void addNewBook() {
        book = tester.addNewBookToLibrary(title, year, author);
    }

    @Test
    public void removeBookFromLibraryShouldRemoveABookFromBookList() {
        int bookId = book.getId();
        tester.removeBookFromLibrary(bookId);
        Book bookFromList = tester.findBookInBookListById(bookId);
        assertThat(bookFromList, equalTo(null));
    }

}
