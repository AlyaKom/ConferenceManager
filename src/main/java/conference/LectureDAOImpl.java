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
public class LectureDAOImpl implements LectureDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Lecture lecture) {
        entityManager.merge(lecture);
    }

    @Override
    public void delete(Lecture lecture) {
        entityManager.remove(lecture);
    }

    @Override
    public void delete(long[] ids) {
        Lecture l;
        for (long id : ids) {
            l = entityManager.getReference(Lecture.class, id);
            entityManager.remove(l);
        }
    }

    @Override
    public List<Lecture> list(SciSection section) {
        Query query;

        if (section != null) {
            query = entityManager.createQuery("SELECT l FROM Lecture l WHERE l.section = :section", Lecture.class);
            query.setParameter("section", section);
        } else {
            query = entityManager.createQuery("SELECT l FROM Lecture l", Lecture.class);
        }

        return (List<Lecture>) query.getResultList();
    }

    @Override
    public List<Lecture> list() {
        Query query = entityManager.createQuery("SELECT l FROM Lecture l", Lecture.class);
        return (List<Lecture>) query.getResultList();
    }

    @Override
    public Lecture findOne(long id) {
        return entityManager.getReference(Lecture.class, id);
    }

    @Override
    public List<Lecture> list(Participant participant) {
        Query query;

        if (participant != null) {
            query = entityManager.createQuery("SELECT l FROM Lecture l WHERE l.participant = :participant", Lecture.class);
            query.setParameter("participant", participant);
        } else {
            query = entityManager.createQuery("SELECT l FROM Lecture l", Lecture.class);
        }

        return (List<Lecture>) query.getResultList();
    }


    @Override
    public List<Lecture> list(String pattern) {
        Query query = entityManager.createQuery("SELECT l FROM Lecture l WHERE l.name LIKE :pattern", Lecture.class);
        query.setParameter("pattern", "%" + pattern + "%");
        return (List<Lecture>) query.getResultList();
    }
}
