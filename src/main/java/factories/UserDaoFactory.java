package factories;

import dao.UserDAO;
import dao.UserHibernateDAO;
import dao.UserJdbcDAO;
import property.DBProperty;

public class UserDaoFactory {
    private static UserDAO userDao;

    public UserDaoFactory() {
        String daoFromProperty = DBProperty.getUserDAOProperties();
        if (daoFromProperty.equals("Hibernate")) {
            userDao = new UserHibernateDAO();
        } else {
            userDao = new UserJdbcDAO();
        }
    }

    public UserDAO getUserDAO() {
        return userDao;
    }
}