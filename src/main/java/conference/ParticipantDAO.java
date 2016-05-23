package conference;

import java.util.List;

/**
 * Created by Komyshan on 05.05.2016.
 */
public interface ParticipantDAO {
    void add(Participant participant);
    void delete(Participant participant);
    void delete(long[] ids);
    Participant findOne(long id);
    List<Participant> list();
    List<Participant> list(String pattern);
}
