package hu.tigra.tutorial.ejb

import hu.tigra.tutorial.dao.UserDAO
import hu.tigra.tutorial.dmo.User
import spock.lang.Specification


/**
 * Created with IntelliJ IDEA.
 * Date: 2014.12.04.
 * Time: 19:24
 */
class UserStatFacadeSpockTest extends Specification {

    def "CalculateAgeDistributionByPostcode"() {
        setup:
        UserStatFacade facade = new UserStatFacade()
        facade.userDAO = Mock(UserDAO)
        facade.userDAO.getUsersByPostCode("1111") >> [new User(postcode: "1111", dateOfBirth: new Date())]

        when:
        def ageDistributionByPostcode = facade.calculateAgeDistributionByPostcode("1111")

        then:
        5 == ageDistributionByPostcode.size()
        1l == ageDistributionByPostcode.get(UserStatFacade.AGE_GROUP_KIDS).longValue()
        0l == ageDistributionByPostcode.get(UserStatFacade.AGE_GROUP_TEENS).longValue()

    }
}
