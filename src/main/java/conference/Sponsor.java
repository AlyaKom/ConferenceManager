package conference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Komyshan on 04.05.2016.
 */

@Entity
@Table(name="Sponsor")
public class Sponsor {
    @Id
    @GeneratedValue
    private long id;
    private String company;
    private String phone;
    private String email;
    private String contribution;

    public Sponsor() {}

    public Sponsor(String company, String phone, String email, String contribution) {
        this.company = company;
        this.phone = phone;
        this.email = email;
        this.contribution = contribution;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }


    public String getContribution() {
        return contribution;
    }

    public void setAppointment(String contribution) {
        this.contribution = contribution;
    }
}
