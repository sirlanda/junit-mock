package hu.tigra.tutorial.ejb;

import hu.tigra.tutorial.dao.UserDAO;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class UserStatFacadeTest {

    @Test
    public void testCalculateAgeDistributionByPostcode() throws Exception {
        UserStatFacade facade = new UserStatFacade();
        facade.userDAO = new UserDAO();

        final Map<String, Long> ageDistributionByPostcode = facade.calculateAgeDistributionByPostcode("1111");

        assertEquals(5, ageDistributionByPostcode.size());
        assertEquals(1l, ageDistributionByPostcode.get(UserStatFacade.AGE_GROUP_KIDS).longValue());
        assertEquals(0l, ageDistributionByPostcode.get(UserStatFacade.AGE_GROUP_TEENS).longValue());
    }
}