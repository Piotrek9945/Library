import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
       RemoveBookTest.class,
       RemoveLentBookTest.class,
       SearchExistingBookInLibraryTest.class,
       SearchNotExistingBookInLibraryTest.class,
})
public class LibraryTestSuite {

}
