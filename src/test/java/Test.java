import models.User;
import services.UserService;

import java.sql.SQLException;
import java.time.LocalDate;

public class Test {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserService();
        userService.addUser(new User("Dimasik",
                "Mexinoa",
                "dasa211dc",
                LocalDate.parse("1992-01-01")));


    }
}

