package conference;
import java.util.List;

/**
 * Created by Komyshan on 05.05.2016.
 */

public interface SponsorDAO {
    void add(Sponsor sponsor);
    void delete(Sponsor sponsor);
    void delete(long[] ids);
    Sponsor findOne(long id);
    List<Sponsor> list();
}