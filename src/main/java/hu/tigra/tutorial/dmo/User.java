package hu.tigra.tutorial.dmo;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Date: 2014.12.04.
 * Time: 11:46
 */
//@Entity(name = "User")
//@Table(name = "TUT_USER")
public class User {

    // application specific data
    private Long id;
    private String username;
    private String password;

    // address
    private String postcode;
    private String settlement;
    private String address;

    // personal details
    private Date dateOfBirth;
    private String profession;

//  @Id
//  @Basic(optional = false)
//  @NotNull
//  @SequenceGenerator(name = "S_TUT_USER", sequenceName = "S_TUT_USER")
//  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_TUT_USER")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getSettlement() {
        return settlement;
    }

    public void setSettlement(String settlement) {
        this.settlement = settlement;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
