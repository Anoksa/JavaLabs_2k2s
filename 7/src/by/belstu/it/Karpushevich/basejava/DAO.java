package by.belstu.it.Karpushevich.basejava;
import java.sql.*;
import java.util.ArrayList;

public class DAO {
    Connection connection;
    public CitiesDAO Cities;
    public ResidentsDAO Residents;

    public DAO()  {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection ("jdbc:sqlserver://PC\\SQLEXPRESS; databaseName=Cities; ", "PC", "Password1");
            Cities = new CitiesDAO(connection);
            Residents = new ResidentsDAO(connection);
        }
        catch (ClassNotFoundException | SQLException e) {
            System.out.println("DAO constructor failure");
            e.printStackTrace();
        }
    }

    public ArrayList<String> ResidentsByLanguage(String city, String lang){
        ArrayList<String> res = new ArrayList<String>();
        try{
            String preSql = "select Residents.City_Name, Residents.Name, Residents.Language From Residents where Residents.City_Name = ? and Residents.Language = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(preSql);
            preparedStatement.setString(1, city);
            preparedStatement.setString(2, lang);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                String line ="Название: "+ rs.getString(1) +
                        " | Национальность: " + rs.getString(2) +
                        " | Язык: " + rs.getString(3);
                res.add(line);
            }
            preparedStatement.close();
    }
        catch (SQLException e){
            e.printStackTrace();
        } finally {
            return res;
        }
        }

        public ArrayList<String> CitiesByResidents(String resident) {
            ArrayList<String> res = new ArrayList<String>();
            try{
                String preSql = "SELECT Residents.Name, Cities.City_Name, Cities.Foundation_year, Cities.Area, Cities.Population\n" +
                        "FROM   Cities INNER JOIN\n" +
                        "             Residents ON Cities.City_Name = Residents.City_Name\n" +
                        "Where Residents.Name  = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(preSql);
                preparedStatement.setString(1, resident);

                ResultSet rs = preparedStatement.executeQuery();
                while(rs.next()){
                    String line ="Национальность: " + rs.getString(1) + " | Название города: "
                            + rs.getString(2) + " | Год основания: " +
                            rs.getInt(3) + " | Площадь: " +
                            rs.getFloat(4) + " | Население: "+
                            rs.getInt(5);
                    res.add(line);
                }
                preparedStatement.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            } finally {
                return res;
            }
        }

    public ArrayList<String> CityByPopulation(int population) {
        ArrayList<String> res = new ArrayList<String>();
        try{
            String preSql = "SELECT Cities.Population, Cities.City_Name, Cities.Foundation_year, Cities.Area, Residents.Name, Residents.Language\n" +
                    "FROM   Cities INNER JOIN\n" +
                    "             Residents ON Cities.City_Name = Residents.City_Name\n" +
                    "Where Cities.Population = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(preSql);
            preparedStatement.setInt(1, population);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                String line ="Население: " + rs.getInt(1) + " | Название города: "
                        + rs.getString(2) + " | Год основания: " +
                        rs.getInt(3) + " | Площадь: " +
                        rs.getFloat(4) + " | Национальность: "+
                        rs.getString(5) + " | Язык: " +
                        rs.getString(6);
                res.add(line);
            }
            preparedStatement.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        } finally {
            return res;
        }
    }

    public ArrayList<String> OldestCity() {
        ArrayList<String> res = new ArrayList<String>();
        try{
            String preSql = "SELECT Top(1) Cities.Foundation_year, Cities.City_Name,  Cities.Area, Cities.Population\n" +
                    "FROM   Cities INNER JOIN\n" +
                    "             Residents ON Cities.City_Name = Residents.City_Name\n" +
                    "Order by Cities.Foundation_year";
            PreparedStatement preparedStatement = connection.prepareStatement(preSql);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                String line ="Год основания: " + rs.getInt(1) +
                        " | Название: " + rs.getString(2) +
                        " | Площадь: "+ rs.getFloat(3) +
                        " | Население: " + rs.getInt(4);
                res.add(line);
            }
            preparedStatement.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        } finally {
            return res;
        }
    }

    public void AddResident(String city, String name, String lang) throws SQLException {
        Savepoint savepoint = null;
        try{
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint("svpoint");
            String preSQL = "insert into Residents(City_Name, Name, Language) values (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(preSQL);
            preparedStatement.setString(1,city);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,lang);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e){
            e.printStackTrace();
            connection.rollback(savepoint);
        }
    }



    public void CloseDAO(){
        try{
            this.connection.close();
            System.out.println("\nСоединение закрыто");
        } catch (SQLException e){
            System.out.println("DAO connection close failure");
            e.printStackTrace();
        }
    }
}
