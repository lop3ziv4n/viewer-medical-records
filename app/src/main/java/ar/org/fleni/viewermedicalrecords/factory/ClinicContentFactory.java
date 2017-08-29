package ar.org.fleni.viewermedicalrecords.factory;

import java.util.ArrayList;
import java.util.List;

import ar.org.fleni.viewermedicalrecords.mapper.ClinicContent;

/**
 * Created by iv4nlop3z on 29/09/16.
 */
public class ClinicContentFactory {

    private static ClinicContentFactory factory = new ClinicContentFactory();
    private List<ClinicContent> clinicContents = new ArrayList<>();

    /**
     * @return ClinicContentFactory
     */
    public static ClinicContentFactory getInstance() {
        return factory;
    }

    /**
     *
     */
    private ClinicContentFactory() {
        saveClinicContent(new ClinicContent("section 1", "clinical information associated section one of the document referred"));
        saveClinicContent(new ClinicContent("section 2", "clinical information associated section two of the document referred"));
        saveClinicContent(new ClinicContent("section 3", "clinical information associated section tree of the document referred"));
        saveClinicContent(new ClinicContent("section 4", "clinical information associated section four of the document referred"));
        saveClinicContent(new ClinicContent("section 5", "clinical information associated section five of the document referred"));
        saveClinicContent(new ClinicContent("section 6", "clinical information associated section six of the document referred"));
        saveClinicContent(new ClinicContent("section 7", "clinical information associated section seven of the document referred"));
        saveClinicContent(new ClinicContent("section 8", "clinical information associated section eight of the document referred"));
        saveClinicContent(new ClinicContent("section 9", "clinical information associated section nine of the document referred"));
        saveClinicContent(new ClinicContent("section 10", "clinical information associated section ten of the document referred"));
    }

    /**
     * @param clinicContent type ClinicContent
     */
    private void saveClinicContent(ClinicContent clinicContent) {
        clinicContents.add(clinicContent);
    }

    /**
     * @return List
     */
    public List<ClinicContent> getClinicContents() {
        return clinicContents;
    }
}
