package ar.org.fleni.viewermedicalrecords.adapter.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ar.org.fleni.viewermedicalrecords.mapper.ClinicContent;
import ar.org.fleni.viewermedicalrecords.mapper.Episode;

/**
 * Created by ivlopez on 03/10/2016.
 */
public class ClinicContentDTO implements Serializable {

    /**
     * List ClinicContent
     */
    private List<ClinicContent> clinicContentList = new ArrayList<>();

    /**
     * @param clinicContentList type List
     */
    public ClinicContentDTO(List<ClinicContent> clinicContentList) {
        this.clinicContentList = clinicContentList;
    }

    /**
     * @return List
     */
    public List<ClinicContent> getClinicContentList() {
        return clinicContentList;
    }

    /**
     * @param clinicContentList type List
     */
    public void setClinicContentList(List<ClinicContent> clinicContentList) {
        this.clinicContentList = clinicContentList;
    }
}
