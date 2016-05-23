package conference;

import javax.persistence.*;

/**
 * Created by Komyshan on 04.05.2016.
 */

@Entity
@Table(name="OrgCommittee")
public class OrgCommittee {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String appointment;

    public OrgCommittee() {}

    public OrgCommittee(String name, String surname, String phone, String email, String appointment) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.appointment = appointment;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String company) {
        this.appointment = company;
    }
}

