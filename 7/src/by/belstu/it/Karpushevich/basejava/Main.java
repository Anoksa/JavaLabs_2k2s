package by.belstu.it.Karpushevich.basejava;
import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {
        DAO dao = new DAO();
        ArrayList<String> test1 = dao.Cities.GetAll();
        ArrayList<String> test2 = dao.Residents.GetAll();
        ArrayList<String> test3 = dao.ResidentsByLanguage("Токио", "Русский");
        ArrayList<String> test4 = dao.CitiesByResidents("Американцы");
        ArrayList<String> test5 = dao.CityByPopulation(222491);
        ArrayList<String> test6 = dao.OldestCity();
        for (String l: test1) {
            System.out.println(l);
        }
        System.out.println("----------------------");
        for (String l: test2) {
            System.out.println(l);
        }
        System.out.println("----------------------");
        for (String l: test3) {
            System.out.println(l);
        }
        System.out.println("----------------------");
        for (String l: test4) {
            System.out.println(l);
        }
        System.out.println("----------------------");
        for (String l: test5) {
            System.out.println(l);
        }
        System.out.println("----------------------");
        for (String l: test6) {
            System.out.println(l);
        }
        dao.CloseDAO();
    }
}
