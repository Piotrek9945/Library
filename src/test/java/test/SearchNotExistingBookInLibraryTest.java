package test;

import app.Library;
import model.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class SearchNotExistingBookInLibraryTest {

    @Parameterized.Parameter(0)
    public String title;

    @Parameterized.Parameter(1)
    public Integer year;

    @Parameterized.Parameter(2)
    public String author;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                { "Pan", 1732, "Adam Mickiewicz" },
                { null, 1752, "Adam Mickiewicz" },
                { "Pan Tadeusz", null, "Mickiewicz" },
                { "Pan Tadeusz", 1132, null },
                { null, null, "Adam" },
                { "Tadeusz", null, null }
        };
        return Arrays.asList(data);
    }


    Library tester = new Library();
    Book book = null;

    @Before
    public void addNewBook() {
        book = tester.addNewBookToLibrary("Pan Tadeusz" , 1732, "Adam Mickiewicz");
    }

    @Test
    public void searchBookInLibraryWithMistakeShouldReturnNull() {
        Book searchBook = tester.searchBook(title, year, author);
        assertThat(searchBook, equalTo(null));
    }
}
