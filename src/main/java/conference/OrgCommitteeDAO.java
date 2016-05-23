package conference;
import java.util.List;

/**
 * Created by Komyshan on 05.05.2016.
 */

public interface OrgCommitteeDAO {
    void add(OrgCommittee orgCommittee);
    void delete(OrgCommittee orgCommittee);
    void delete(long[] ids);
    OrgCommittee findOne(long id);
    List<OrgCommittee> list();
}