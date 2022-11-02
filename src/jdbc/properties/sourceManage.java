package jdbc.properties;


import java.io.IOException;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class sourceManage {
    private static final Properties conf = new Properties();

    public static String getProp(String key) {
        return conf.getProperty(key);
    }
    static {
        InputStream in = sourceManage.class.getClassLoader().getResourceAsStream("source.properties");
        try {
            conf.load(in);
        } catch (IOException ex) {
            ex.printStackTrace();;
        }
    }


}
