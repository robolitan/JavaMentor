package property;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DBProperty {
    private DBProperty() {

    }

    public static String getUserDAOProperties() {
        Properties properties = new Properties();
        String path = new DBProperty().getClass().getClassLoader().getResource("db.property").getPath();
        try (FileInputStream fis = new FileInputStream(new File(path))) {
            properties.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty("userDAOWith", "JDBC");
    }
}
