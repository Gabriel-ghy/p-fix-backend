package pioneer.pfix.Dao;

import pioneer.pfix.Configuration.DatabaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
    private Connection conn;
    final DatabaseConfig databaseConfig = new DatabaseConfig();
    public Connection getConn() throws Exception
    {
        if(conn==null)
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://"+databaseConfig.getMyConf("address")+"/pfix?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC", databaseConfig.getMyConf("user"), databaseConfig.getMyConf("password"));
        }
        return conn;
    }

    public void closeConn() throws SQLException {
        if(!(conn.isClosed())) {
            conn.close();
        }
    }
}
