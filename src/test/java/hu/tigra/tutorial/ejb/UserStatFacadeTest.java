package hu.tigra.tutorial.ejb;

import hu.tigra.tutorial.dao.UserDAO;
import hu.tigra.tutorial.dmo.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class UserStatFacadeTest {

    @Test
    public void testCalculateAgeDistributionByPostcode() throws Exception {
        UserStatFacade facade = new UserStatFacade();
        facade.userDAO = new UserDAO() {
            @Override
            public List<User> getUsersByPostCode(String postcode) {
                final User user = new User();
                user.setDateOfBirth(new Date());
                return Arrays.asList(user);
            }
        };

        final Map<String, Long> ageDistributionByPostcode = facade.calculateAgeDistributionByPostcode("1111");

        assertEquals(5, ageDistributionByPostcode.size());
        assertEquals(1l, ageDistributionByPostcode.get(UserStatFacade.AGE_GROUP_KIDS).longValue());
        assertEquals(0l, ageDistributionByPostcode.get(UserStatFacade.AGE_GROUP_TEENS).longValue());
    }
}