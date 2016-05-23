package conference;


import javax.persistence.*;

/**
 * Created by Komyshan on 04.05.2016.
 */

@Entity
@Table(name="Lectures")
public class Lecture {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @OneToOne
    @JoinColumn(name="participant_id")
    private Participant participant;

    @ManyToOne
    @JoinColumn(name="section_id")
    private SciSection section;

    private String text;

    public Lecture() {}

    public Lecture(String name, Participant participant, SciSection section, String text) {
        this.name = name;
        this.participant = participant;
        this.section = section;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SciSection getSection() {
        return section;
    }

    public void setSection(SciSection section) {
        this.section = section;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }
}
