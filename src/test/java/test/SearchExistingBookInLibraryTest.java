package test;

import app.Library;
import model.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class SearchExistingBookInLibraryTest {

    @Parameterized.Parameter(0)
    public String title;

    @Parameterized.Parameter(1)
    public Integer year;

    @Parameterized.Parameter(2)
    public String author;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                { "Pan Tadeusz", 1732, "Adam Mickiewicz" },
                { null, 1732, "Adam Mickiewicz" },
                { "Pan Tadeusz", null, "Adam Mickiewicz" },
                { "Pan Tadeusz", 1732, null },
                { null, null, "Adam Mickiewicz" },
                { "Pan Tadeusz", null, null }
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
    public void searchBookInLibraryShouldReturnIdenticBookWhichWasAdded() {
        Book searchBook = tester.searchBook(title, year, author);
        assertThat(this.book, sameInstance(searchBook));
    }

}
