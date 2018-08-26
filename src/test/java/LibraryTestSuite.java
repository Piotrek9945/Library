import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
       RemoveBookTest.class,
       RemoveLentBookTest.class,
       SearchBookInLibraryTest.class,
})
public class LibraryTestSuite {

}
