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
public class OrgCommitteeDAOImpl implements OrgCommitteeDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(OrgCommittee orgCommittee) {
        entityManager.persist(orgCommittee);
    }

    @Override
    public void delete(OrgCommittee orgCommittee) {
        entityManager.remove(orgCommittee);
    }

    @Override
    public OrgCommittee findOne(long id) {
        return entityManager.getReference(OrgCommittee.class, id);
    }

    @Override
    public List<OrgCommittee> list() {
        Query query = entityManager.createQuery("SELECT s FROM OrgCommittee s", OrgCommittee.class);
        return (List<OrgCommittee>) query.getResultList();
    }

    @Override
    public void delete(long[] ids) {
        OrgCommittee c;
        for (long id : ids) {
            c = entityManager.getReference(OrgCommittee.class, id);
            entityManager.remove(c);
        }
    }
}
