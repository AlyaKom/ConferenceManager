package conference;
import java.util.List;
/**
 * Created by Komyshan on 05.05.2016.
 */


public interface SciSectionDAO {
    void add(SciSection section);
    void delete(SciSection section);
    void delete(long[] ids);
    SciSection findOne(long id);
    List<SciSection> list();
}