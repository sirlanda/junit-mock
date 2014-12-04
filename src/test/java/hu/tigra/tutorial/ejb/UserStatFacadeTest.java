package hu.tigra.tutorial.ejb;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class UserStatFacadeTest {

    @Test
    public void testCalculateAgeDistributionByPostcode() throws Exception {
        UserStatFacade facade = new UserStatFacade();
        final Map<String, Long> ageDistributionByPostcode = facade.calculateAgeDistributionByPostcode("1111");

        assertEquals(5, ageDistributionByPostcode.size());
    }
}