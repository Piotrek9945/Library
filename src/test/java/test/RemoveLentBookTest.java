package test;

import app.Library;
import model.Book;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.assertThat;

public class RemoveLentBookTest {

    Library tester = new Library();
    Book book;

    @Before
    public void addNewBook() {
        book = tester.addNewBookToLibrary("Pan Tadeusz" , 1732, "Adam Mickiewicz");
    }

    @Test
    public void removeLentBookFromLibraryShouldNotRemoveABookFromBookList() {
        int bookId = book.getId();
        tester.lendBook(bookId, "Jan");
        tester.removeBookFromLibrary(bookId);
        Book bookFromList = tester.findBookInBookListById(bookId);
        assertThat(bookFromList, sameInstance(this.book));
    }

}
