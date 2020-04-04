package obj;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import stdc.IdName;

import javax.persistence.Column;

import static stdc.IdName.ColumnName.ID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends IdName {
    public static final String TABLE_NAME = "user";
    public static final String FOREIGN_KEY_NAME = TABLE_NAME + "_" + ID;

    public static class ColumnName {
        public static final String USERNAME = "username";
        public static final String PASSWORD = "password";
        public static final String EMAIL = "email";
        public static final String APARTMENT = Apartment.TABLE_NAME + "_" + ID;
    }

    public User() {

    }

    @Column(name = ColumnName.USERNAME)
    private String username;
    @Column(name = ColumnName.PASSWORD)
    private String password;
    @Column(name = ColumnName.EMAIL)
    private String email;
    @Column(name = ColumnName.APARTMENT)
    private int apartmentId;

    private Apartment apartment = new Apartment();

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

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getApartmentId() {
        return apartmentId;
    }
    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }

    public Apartment getApartment() {
        return apartment;
    }
    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }
}
