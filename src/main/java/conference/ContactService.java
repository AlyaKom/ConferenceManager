package conference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Komyshan on 12.05.2016.
 */
@Service
public class ContactService {
    @Autowired
    private LectureDAO lectureDAO;
    @Autowired
    private ParticipantDAO participantDAO;
    @Autowired
    private SciSectionDAO sciSectionDAO;
    @Autowired
    private SponsorDAO sponsorDAO;
    @Autowired
    private OrgCommitteeDAO orgCommitteeDAO;

    @Transactional
    public void addLecture(Lecture lecture) {
        lectureDAO.add(lecture);
    }

    @Transactional
    public void addParticipant(Participant participant) {
        participantDAO.add(participant);
    }
    @Transactional
         public void addSection(SciSection sciSection) {
        sciSectionDAO.add(sciSection);
    }
    @Transactional
         public void addSponsor(Sponsor sponsor) {
        sponsorDAO.add(sponsor);
    }
    @Transactional
         public void addCommittee(OrgCommittee orgCommittee) {
        orgCommitteeDAO.add(orgCommittee);
    }

    @Transactional(readOnly=true)
     public List<Sponsor> listSponsors() {
        return sponsorDAO.list();
    }

    @Transactional(readOnly=true)
    public List<SciSection> listSections() {
        return sciSectionDAO.list();
    }

    @Transactional(readOnly=true)
    public List<OrgCommittee> listCommittee() {
        return orgCommitteeDAO.list();
    }

    @Transactional
         public void deleteSection(long[] ids) {
        sciSectionDAO.delete(ids);
    }

    @Transactional
    public void deleteSponsors(long[] ids) {
        sponsorDAO.delete(ids);
    }

    @Transactional
    public void deleteOrgCommittees(long[] ids) { orgCommitteeDAO.delete(ids); }

    @Transactional
    public void deleteParticipants(long[] ids) { participantDAO.delete(ids);  }

    @Transactional
    public void deleteLectures(long[] ids) { lectureDAO.delete(ids); }

    @Transactional(readOnly=true)
     public List<Participant> listParticipants() {
        return participantDAO.list();
    }

    @Transactional(readOnly=true)
    public List<Lecture> listLectures() {
        return lectureDAO.list();
    }

    @Transactional(readOnly=true)
    public List<Lecture> listLecturesS(SciSection section) {
        return lectureDAO.list(section);
    }

    @Transactional(readOnly=true)
    public List<Lecture> listLecturesP(Participant participant) {
        return lectureDAO.list(participant);
    }

    @Transactional(readOnly=true)
    public List<Participant> searchParticipants(String pattern) {
        return participantDAO.list(pattern);
    }

    @Transactional(readOnly=true)
    public List<Lecture> searchLectures(String pattern) {
        return lectureDAO.list(pattern);
    }

    @Transactional(readOnly=true)
    public Participant findParticipant(long id) {
        return participantDAO.findOne(id);
    }

    @Transactional(readOnly=true)
    public SciSection findSection(long id) {
        return sciSectionDAO.findOne(id);
    }

    @Transactional(readOnly=true)
    public Lecture findLecture(long id) {
        return lectureDAO.findOne(id);
    }

}

