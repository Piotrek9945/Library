import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AddBookToEmptyLibraryTest.class,
       AddBookToLibraryWithOneBookTest.class,
       LendBookTest.class,
       RemoveLentBookTest.class,
       RemoveBookTest.class,
       SearchBookInLibraryWithOneBookTest.class,
       SearchBookInLibraryWithTwoBooksTest.class
})
public class LibraryTestSuite {

}
