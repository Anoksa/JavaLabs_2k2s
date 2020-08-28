package by.kremen.bookshop;


import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;




@RunWith(Suite.class)
@Suite.SuiteClasses({BookSailerTest.class, BookshopTest.class})
public class SuiteTest {
    @BeforeClass
    public static void bef() {
        System.out.println("before suit test");
    }

    @Test
    void checkSuite() {
        System.out.println("Suit test");
    }

    @AfterClass
    public static void aft() {
        System.out.println("after suit test");
    }
}
