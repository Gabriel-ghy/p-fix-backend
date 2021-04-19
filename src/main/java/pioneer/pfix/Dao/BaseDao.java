package pioneer.pfix.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
    private Connection conn;
    public Connection getConn() throws Exception
    {
        if(conn==null)
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/pfix?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC", "root", "1023464930");
        }
        return conn;
    }

    public void closeConn() throws SQLException {
        if(!(conn.isClosed())) {
            conn.close();
        }
    }
}
