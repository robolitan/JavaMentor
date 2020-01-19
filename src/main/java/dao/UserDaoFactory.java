package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class UserDaoFactory {
    private static UserDAO userDao;

    public UserDaoFactory() {
    }
    public UserDAO getUserDAO() {
        if (getUserDAOProperties().equals("Hibernate")) {
            userDao = new UserHibernateDAO();
        } else {
            userDao = new UserJdbcDAO();
        }
        return userDao;
    }

    private static String getUserDAOProperties() {
        Properties properties = new Properties();
        StringBuilder path = new StringBuilder(System.getProperty("user.dir"))
                .append(File.separator).append("..")
                .append(File.separator).append("webapps")
                .append(File.separator).append("task1-1")
                .append(File.separator).append("WEB-INF")
                .append(File.separator).append("classes")
                .append(File.separator).append("db.property");
        try (FileInputStream fis = new FileInputStream(new File(path.toString()))) {
            properties.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty("userDAOWith", "JDBC");
    }
}
