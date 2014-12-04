package hu.tigra.tutorial.ejb;

import hu.tigra.tutorial.dao.UserDAO;
import hu.tigra.tutorial.dmo.User;
import org.joda.time.DateTime;
import org.joda.time.Years;

import java.util.Date;
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

        List<User> users = userDAO.getUsersByPostCode(postcode);
        for (User user : users) {
            int age = getAgeFromBirthDate(user.getDateOfBirth());
            if (age < 15) {
                stat.put(AGE_GROUP_KIDS, stat.get(AGE_GROUP_KIDS) + 1);
            } else if (age < 19) {
                stat.put(AGE_GROUP_TEENS, stat.get(AGE_GROUP_TEENS) + 1);
            } else if (age < 26) {
                stat.put(AGE_GROUP_STUDENTS, stat.get(AGE_GROUP_STUDENTS) + 1);
            } else if (age < 41) {
                stat.put(AGE_GROUP_ADULTS, stat.get(AGE_GROUP_ADULTS) + 1);
            } else {
                stat.put(AGE_GROUP_OLD_STAGERS, stat.get(AGE_GROUP_OLD_STAGERS) + 1);
            }
        }

        return stat;
    }

    private int getAgeFromBirthDate(Date dateOfBirth) {
        return Years.yearsBetween(new DateTime(dateOfBirth.getTime()), DateTime.now()).getYears();
    }

}
