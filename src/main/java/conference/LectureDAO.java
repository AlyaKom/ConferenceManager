package conference;

import java.util.List;

/**
 * Created by Komyshan on 05.05.2016.
 */

public interface LectureDAO {
    void add(Lecture lecture);
    void delete(Lecture lecture);
    void delete(long[] ids);
    Lecture findOne(long id);
    List<Lecture> list();
    List<Lecture> list(SciSection section);
    List<Lecture> list(Participant participant);
    List<Lecture> list(String pattern);
}
