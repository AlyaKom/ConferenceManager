package conference;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Komyshan on 04.05.2016.
 */

@Entity
@Table(name="Sections")
public class SciSection {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @OneToMany(mappedBy="section", cascade=CascadeType.ALL)
    private List<Lecture> lectures = new ArrayList<Lecture>();

    public SciSection() {}

    public SciSection(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }
}