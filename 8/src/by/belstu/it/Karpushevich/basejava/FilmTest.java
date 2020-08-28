package by.belstu.it.Karpushevich.basejava;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FilmTest {

    @BeforeClass
    public static void bef() {
        System.out.println("before suit test");
    }

    @AfterClass
    public static void aft(){System.out.println("after suit class");}

    @Before
    public void setUp() {
        System.out.println("before test");
    }

    @After
    public  void tearDown() {
        System.out.println("after test");
    }

    @Test
    public void getAllFilms() {
        System.out.println("Test");
        Film film = new Film("Эквилибриум",2002);
        Film film1 = new Film("Лило и Стич",2002);
        Film film2 = new Film("Звёздная пыль",2007);

        List<Film> expected = Film.getAllFilms();

        List<Film> actual = new ArrayList<>();



        actual.add(film);
        actual.add(film1);
        actual.add(film2);

        //запускаем тест, в случае если список expected и actual не будут равны
        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 200)
    public void getAllUsers_NO_NULL(){
        System.out.println("Test");
        List<Film> expected = Film.getAllFilms();
        Assert.assertNotNull(expected);
    }


    @Test
    public void GetAllFilms_Year() {
        System.out.println("Test");

        Film film = new Film("Эквилибриум",2002);
        Film film1 = new Film("Лило и Стич",2002);
        Film film2 = new Film("Звёздная пыль",2007);

        List<Film> expected = Film.getAllFilms(2002);

        List<Film> actual = new ArrayList<>();
        actual.add(film);
        actual.add(film1);
        //actual.add(film2);

        //запускаем тест, в случае если список expected и actual не будут равны
        Assert.assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public void getHowManyFilms() {
        System.out.println("Test");

        Film film = new Film("Эквилибриум",2002);
        Film film1 = new Film("Лило и Стич",2002);
        Film film2 = new Film("Звёздная пыль",2007);

        int expected = Film.getHowManyFilms();

        int actual = 3;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void GetHowManyFilms_Year() {
        System.out.println("Test");

        Film film = new Film("Эквилибриум",2002);
        Film film1 = new Film("Лило и Стич",2002);
        Film film2 = new Film("Звёздная пыль",2007);

        int expected = Film.getHowManyFilms(2002);

        int actual = 2;

        Assert.assertEquals(expected, actual);
    }


}