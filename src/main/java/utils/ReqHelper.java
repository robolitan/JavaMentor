package utils;

import models.Gender;
import models.User;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Map;

public interface ReqHelper {

    default User getUserFromReq(HttpServletRequest request) {
        Map<String, String[]> parameters = request.getParameterMap();
        String name = parameters.get("name")[0];
        String password = parameters.get("password")[0];
        String gender = parameters.get("gender")[0].toUpperCase();
        String birthday = parameters.get("birthday")[0];
        User user = null;
        int id;
        if (parameters.get("id")!= null) {
           user = new User(Integer.parseInt(parameters.get("id")[0]),
                   name,
                   password,
                   Gender.valueOf(gender),
                   LocalDate.parse(birthday));
        }
        else {
            user = new User(name,
                    password,
                    Gender.valueOf(gender),
                    LocalDate.parse(birthday));
        }
        return user;
    }

    default String getParametrs(HttpServletRequest request, String param) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        return parameterMap.get(param)[0];
    }
}
