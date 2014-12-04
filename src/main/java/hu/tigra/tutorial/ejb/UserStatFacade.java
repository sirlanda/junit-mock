package hu.tigra.tutorial.ejb;

import hu.tigra.tutorial.dao.UserDAO;
import hu.tigra.tutorial.dmo.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Date: 2014.12.04.
 * Time: 11:45
 */
public class UserStatFacade {

    public static final String AGE_GROUP_KIDS = "1. Kids (0-14)";
    public static final String AGE_GROUP_TEENS = "2. Teens (15-18)";
    public static final String AGE_GROUP_STUDENTS = "3. Students (19-25)";
    public static final String AGE_GROUP_ADULTS = "4. Adults (26-40)";
    public static final String AGE_GROUP_OLD_STAGERS = "5. Old stagers (41-)";

    //@Inject
    UserDAO userDAO;

    public Map<String, Long> calculateAgeDistributionByPostcode(String postcode) {
        Map<String, Long> stat = new HashMap<>();
        stat.put(AGE_GROUP_KIDS, 0l);
        stat.put(AGE_GROUP_TEENS, 0l);
        stat.put(AGE_GROUP_STUDENTS, 0l);
        stat.put(AGE_GROUP_ADULTS, 0l);
        stat.put(AGE_GROUP_OLD_STAGERS, 0l);

        /*List<User> users = userDAO.getUsersByPostCode(postcode);
        for (User user : users) {

        }*/
        return stat;
    }

}
