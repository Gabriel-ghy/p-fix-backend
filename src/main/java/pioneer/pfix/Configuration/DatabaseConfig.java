package pioneer.pfix.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {
    public static Properties myProp = new Properties();
    public static InputStream myResource = DatabaseConfig.class.getResourceAsStream("/database.properties");
    static {
        try {
            myProp.load(myResource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getMyConf(String props) {
        return myProp.getProperty(props);
    }

    public static void main(String[] args) {
        final DatabaseConfig databaseConfig = new DatabaseConfig();
        System.out.println(databaseConfig.getMyConf("user"));
    }
}
