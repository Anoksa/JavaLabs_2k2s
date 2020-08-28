package by.belstu.it.Karpushevich.basejava;

public class Main {

    public static void main(String[] args) {
	    new Film("Достать ножи", 2019);
	    new Film("Белая змея", 2019);
	    new Film("Город героев", 2014);
	    new Film("Мег: Монстр глубины", 2018);
	    new Film("Зеленая миля", 1999);
	    new Film("Тёмный рыцарь", 2008);
	    new Film("Первому игроку приготовиться", 2018);
	    new Film("Тёмное зеркало", 2018);
	    new Film("Комната желаний", 2019);
	    new Film("Наркоз", 2007);

	    System.out.println("Все фильмы");
	    Film.getAllFilms().forEach(System.out::println);
	    System.out.println("Все фильмы 2019 года:");
	    Film.getAllFilms(2019).forEach(System.out::println);
		System.out.println("Все фильмы 2018 года:");
		Film.getAllFilms(2018).forEach(System.out::println);
	    System.out.println("=====================================");
	    System.out.println("         Всего фильмов: "  + Film.getHowManyFilms());
	    System.out.println("Всего фильмов 2019 года: " + Film.getHowManyFilms(2019));
	    System.out.println("Всего фильмов 2018 года: " + Film.getHowManyFilms(2018));


    }
}
