package hu.tigra.tutorial.dao;

import hu.tigra.tutorial.dmo.User;

/*
import java.util.Arrays;
import java.util.Date;
*/
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2014.12.04.
 * Time: 11:46
 */
public class UserDAO {

    public List<User> getUsersByPostCode(String postcode) {
/*
        final User user = new User();
        user.setDateOfBirth(new Date());
        return Arrays.asList(user);
*/
        throw new RuntimeException("Unit tests should not access external resources like DBs, queues or files");
    }
}
