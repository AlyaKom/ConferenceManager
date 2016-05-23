package conference;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Komyshan on 05.05.2016.
 */

@Repository
public class ParticipantDAOImpl implements ParticipantDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Participant participant) {
        entityManager.merge(participant);
    }

    @Override
    public void delete(Participant participant) {
        entityManager.remove(participant);
    }

    @Override
    public void delete(long[] ids) {
        Participant p;
        for (long id : ids) {
            p = entityManager.getReference(Participant.class, id);
            entityManager.remove(p);
        }
    }

    @Override
    public List<Participant> list() {
        Query query = entityManager.createQuery("SELECT p FROM Participant p", Participant.class);
        return (List<Participant>) query.getResultList();
    }

    @Override
    public Participant findOne(long id) {
        return entityManager.getReference(Participant.class, id);
    }

    @Override
    public List<Participant> list(String pattern) {
        Query query = entityManager.createQuery("SELECT p FROM Participant p WHERE p.surname LIKE :pattern", Participant.class);
        query.setParameter("pattern", "%" + pattern + "%");
        return (List<Participant>) query.getResultList();
    }
}
