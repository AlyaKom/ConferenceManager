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
public class SponsorDAOImpl implements SponsorDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Sponsor sponsor) {
        entityManager.persist(sponsor);
    }

    @Override
    public void delete(Sponsor sponsor) {
        entityManager.remove(sponsor);
    }

    @Override
    public Sponsor findOne(long id) {
        return entityManager.getReference(Sponsor.class, id);
    }

    @Override
    public List<Sponsor> list() {
        Query query = entityManager.createQuery("SELECT s FROM Sponsor s", Sponsor.class);
        return (List<Sponsor>) query.getResultList();
    }

    @Override
    public void delete(long[] ids) {
        Sponsor s;
        for (long id : ids) {
            s = entityManager.getReference(Sponsor.class, id);
            entityManager.remove(s);
        }
    }
}