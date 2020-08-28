package by.belstu.it.Karpushevich.basejava;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ResidentsDAO {
    protected Connection connection;

    public ArrayList<String> GetAll() {
        ArrayList<String> res = new ArrayList<String>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from RESIDENTS");
            while(rs.next()) {
                String line ="City: "+rs.getString(1) +
                        " Nationality: "+ rs.getString(2) +
                        " speak " + rs.getString(3);
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

    public ResidentsDAO(Connection con) {
        this.connection = con;
    }
}
