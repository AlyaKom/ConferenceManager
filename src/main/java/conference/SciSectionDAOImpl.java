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
public class SciSectionDAOImpl implements SciSectionDAO{

        @PersistenceContext
        private EntityManager entityManager;

        @Override
        public void add(SciSection section) {
            entityManager.persist(section);
        }

        @Override
        public void delete(SciSection section) {
            entityManager.remove(section);
        }

        @Override
        public SciSection findOne(long id) {
            return entityManager.getReference(SciSection.class, id);
        }

        @Override
        public List<SciSection> list() {
            Query query = entityManager.createQuery("SELECT s FROM SciSection s", SciSection.class);
            return (List<SciSection>) query.getResultList();
        }

        @Override
        public void delete(long[] ids) {
           SciSection s;
             for (long id : ids) {
               s = entityManager.getReference(SciSection.class, id);
             entityManager.remove(s);
             }
        }
    }

