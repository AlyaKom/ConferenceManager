package conference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Komyshan on 12.05.2016.
 */

@Controller
@RequestMapping("/")
public class MyController {
    static final int DEFAULT_PARTICIPANT_ID = -1;
    static final int DEFAULT_SECTION_ID = -1;

    @Autowired
    private ContactService contactService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    //SPONSORS
    @RequestMapping("/sponsor_add")
    public String sponsorAddPage(Model model) {
        model.addAttribute("sponsors", contactService.listSponsors());
        return "sponsor_add";
    }

    @RequestMapping(value = "/sponsor/add", method = RequestMethod.POST)
    public String contactAdd(@RequestParam String company,
                             @RequestParam String phone,
                             @RequestParam String email,
                             @RequestParam String contribution,
                             Model model) {
        Sponsor sponsor = new Sponsor(company, phone, email, contribution);

        contactService.addSponsor(sponsor);

        model.addAttribute("sponsors", contactService.listSponsors());
        return "sponsor_add";
    }

    @RequestMapping(value = "/sponsor/delete", method = RequestMethod.POST)
    public String deleteSponsor(@RequestParam(value = "toDelete[]", required = false) long[] toDelete, Model model) {
        if (toDelete != null)
            contactService.deleteSponsors(toDelete);

        model.addAttribute("sponsors", contactService.listSponsors());
        return "sponsor_add";
    }


    //SECTIONS
    @RequestMapping("/section_add")
    public String sectionAddPage(Model model) {
        model.addAttribute("sections", contactService.listSections());
        return "section_add";
    }

    @RequestMapping(value = "/section/add", method = RequestMethod.POST)
    public String groupAdd(@RequestParam String name, Model model) {
        contactService.addSection(new SciSection(name));

        model.addAttribute("sections", contactService.listSections());
        return "section_add";
    }

    @RequestMapping(value = "/section/delete", method = RequestMethod.POST)
    public String deleteSection(@RequestParam(value = "toDelete[]", required = false) long[] toDelete, Model model) {
        if (toDelete != null)
            contactService.deleteSection(toDelete);

        model.addAttribute("sections", contactService.listSections());
        return "section_add";
    }

    //ORG COMMITTEE
    @RequestMapping("/orgcommittee_add")
    public String orgCommitteeAddPage(Model model) {
        model.addAttribute("orgcommittee", contactService.listCommittee());
        return "orgcommittee_add";
    }

    @RequestMapping(value = "/orgcommittee/add", method = RequestMethod.POST)
    public String contactAdd(@RequestParam String name,
                             @RequestParam String surname,
                             @RequestParam String phone,
                             @RequestParam String email,
                             @RequestParam String appointment,
                             Model model) {
        OrgCommittee orgCommittee = new OrgCommittee(name, surname, phone, email, appointment);

        contactService.addCommittee(orgCommittee);

        model.addAttribute("orgcommittee", contactService.listCommittee());
        return "orgcommittee_add";
    }

    @RequestMapping(value = "/orgcommittee/delete", method = RequestMethod.POST)
    public String deleteCommittee(@RequestParam(value = "toDelete[]", required = false) long[] toDelete, Model model) {
        if (toDelete != null)
            contactService.deleteOrgCommittees(toDelete);

        model.addAttribute("orgcommittee", contactService.listCommittee());
        return "orgcommittee_add";
    }

    // PARTICIPANTS
    @RequestMapping("/participant_add")
    public String participantAddPage(Model model) {
        model.addAttribute("participants", contactService.listParticipants());
        return "participant_add";
    }

    @RequestMapping(value = "/participant/add", method = RequestMethod.POST)
    public String participantAdd(@RequestParam String name,
                                 @RequestParam String surname,
                                 @RequestParam String phone,
                                 @RequestParam String email,
                                 @RequestParam String company,
                                 Model model) {
        Participant participant = new Participant(name, surname, phone, email, company);

        contactService.addParticipant(participant);

        model.addAttribute("participants", contactService.listParticipants());
        return "participant_add";
    }

    @RequestMapping(value = "/participant/delete", method = RequestMethod.POST)
    public String deleteParticipants(@RequestParam(value = "toDelete[]", required = false) long[] toDelete, Model model) {
        if (toDelete != null)
            contactService.deleteParticipants(toDelete);

        model.addAttribute("participants", contactService.listParticipants());
        return "participant_add";
    }

    @RequestMapping(value = "/search_participant", method = RequestMethod.POST)
    public String searchParticipant(@RequestParam String pattern, Model model) {
        model.addAttribute("participants", contactService.searchParticipants(pattern));
        return "participant_add";
    }


    //LECTURES
    @RequestMapping("/lecture_add")
    public String lectureAddPage(Model model) {
        model.addAttribute("participant", contactService.listParticipants());
        model.addAttribute("section", contactService.listSections());
        model.addAttribute("sectionput", contactService.listSections());
        model.addAttribute("lectures", contactService.listLectures());
        return "lecture_add";
    }

    @RequestMapping(value = "/lecture/add", method = RequestMethod.POST)
    public String lectureAdd(@RequestParam String name,
                             @RequestParam(value = "participant") long participantId,
                             @RequestParam(value = "section") long sectionId,
                             @RequestParam String text,
                             Model model) {
        Participant participant = (participantId != DEFAULT_PARTICIPANT_ID) ? contactService.findParticipant(participantId) : null;
        SciSection section = (sectionId != DEFAULT_SECTION_ID) ? contactService.findSection(sectionId) : null;

        Lecture lecture = new Lecture(name, participant, section, text);

        contactService.addLecture(lecture);

        model.addAttribute("participant", contactService.listParticipants());
        model.addAttribute("section", contactService.listSections());
        model.addAttribute("sectionput", contactService.listSections());
        model.addAttribute("lectures", contactService.listLectures());
        return "lecture_add";
    }

    @RequestMapping(value = "/lecture/delete", method = RequestMethod.POST)
    public String deleteLectures(@RequestParam(value = "toDelete[]", required = false) long[] toDelete, Model model) {
        if (toDelete != null)
            contactService.deleteLectures(toDelete);

        model.addAttribute("participant", contactService.listParticipants());
        model.addAttribute("section", contactService.listSections());
        model.addAttribute("sectionput", contactService.listSections());
        model.addAttribute("lectures", contactService.listLectures());
        return "lecture_add";
    }

    @RequestMapping(value = "/search_lecture", method = RequestMethod.POST)
    public String searchLecture(@RequestParam String pattern, Model model) {

        model.addAttribute("participant", contactService.listParticipants());
        model.addAttribute("section", contactService.listSections());
        model.addAttribute("sectionput", contactService.listSections());
        model.addAttribute("lectures", contactService.searchLectures(pattern));
        return "lecture_add";
    }

    @RequestMapping("/lecture/{id}")
    public String listGroup(@PathVariable(value = "id") long lectureId, Model model) {
        Lecture lecture = contactService.findLecture(lectureId);

        model.addAttribute("title", lecture.getName());
        model.addAttribute("section", lecture.getSection().getName());
        model.addAttribute("name", lecture.getParticipant().getName());
        model.addAttribute("surname", lecture.getParticipant().getSurname());
        model.addAttribute("company", lecture.getParticipant().getCompany());
        model.addAttribute("abstract", lecture.getText());
        return "lecture_show";
    }

    @RequestMapping("/section/{id}")
    public String listLecturesS(@PathVariable(value = "id") long sectionId, Model model) {
        SciSection section = (sectionId != DEFAULT_SECTION_ID) ? contactService.findSection(sectionId) : null;

        model.addAttribute("participant", contactService.listParticipants());
        model.addAttribute("section", contactService.listSections());
        model.addAttribute("sectionput", contactService.listSections());
        model.addAttribute("contacts", contactService.listLecturesS(section));
        return "lecture_add";
    }
}