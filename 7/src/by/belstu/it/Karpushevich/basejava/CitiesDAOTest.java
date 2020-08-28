package by.belstu.it.Karpushevich.basejava;

import org.junit.After;
import org.junit.Before;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class CitiesDAOTest {
protected Connection connection;

    @Before
    public void setUp() {
        System.out.println("before CitiesDAOTest test");
    }

    @org.junit.jupiter.api.Test
    void getAll() throws SQLException {
        ArrayList<String> res = new ArrayList<String>();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT  * from Cities");
        while (rs.next()){
            String line = rs.getString(1)  + " Year: " +
                    rs.getInt(2 ) + " Area: " +
                    rs.getFloat(3) + " sq km Population: " +
                    rs.getInt(4) + " ";
            res.add(line);
        }
    }

    @After
    public void tearDown() {
        System.out.println("after CitiesDAOTest test");
    }

}