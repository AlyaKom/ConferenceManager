package conference;


import javax.persistence.*;

/**
 * Created by Komyshan on 04.05.2016.
 */

    @Entity
    @Table(name="Participants")
    public class Participant {
        @Id
        @GeneratedValue
        private long id;

        private String name;
        private String surname;
        private String phone;
        private String email;
        private String company;

        @OneToOne(mappedBy="participant", cascade=CascadeType.ALL)
        private Lecture lecture;

        public Participant() {}

        public Participant(String name, String surname, String phone, String email, String company) {
            this.name = name;
            this.surname = surname;
            this.phone = phone;
            this.email = email;
            this.company = company;
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

        public Lecture getLecture() {
            return lecture;
        }

        public void setLecture(Lecture lecture) {
            this.lecture = lecture;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }
    }
