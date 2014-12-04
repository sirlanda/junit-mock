package hu.tigra.tutorial.ejb;

//import static org.easymock.EasyMock.*;                 // when mocking interfaces
import static org.easymock.classextension.EasyMock.*;    // when mocking classes without interface

import hu.tigra.tutorial.dao.UserDAO;
import hu.tigra.tutorial.dmo.User;
import org.easymock.classextension.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import static org.junit.Assert.*;

public class UserStatFacadeTest {

    UserStatFacade facade;
    UserDAO mockDao;

    @Before
    public void setUp() throws Exception {
        facade = new UserStatFacade();
        mockDao = EasyMock.createMock(UserDAO.class);
        facade.userDAO = mockDao;
    }

    @Test
    public void testCalculateAgeDistributionByPostcode() throws Exception {
        final String postcode = "1111";
        final User user = new User();
        user.setDateOfBirth(new Date());

        expect(mockDao.getUsersByPostCode(postcode)).andReturn(Arrays.asList(user));

        replay(mockDao);

        final Map<String, Long> ageDistributionByPostcode = facade.calculateAgeDistributionByPostcode(postcode);

        assertEquals(5, ageDistributionByPostcode.size());
        assertEquals(1l, ageDistributionByPostcode.get(UserStatFacade.AGE_GROUP_KIDS).longValue());
        assertEquals(0l, ageDistributionByPostcode.get(UserStatFacade.AGE_GROUP_TEENS).longValue());
    }
}