package by.belstu.it.Karpushevich.basejava;

import java.sql.*;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CitiesDAO {
    protected Connection connection;

    public ArrayList<String> GetAll(){
        ArrayList<String> res = new ArrayList<String>();
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT  * from Cities");
            while (rs.next()){
                String line = rs.getString(1)  + " Year: " +
                        rs.getInt(2 ) + " Area: " +
                        rs.getFloat(3) + " sq km Population: " +
                        rs.getInt(4) + " ";
                        res.add(line);
            }
            st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            return res;
        }
    }

    public CitiesDAO(Connection con) {
        this.connection = con;
    }

}
