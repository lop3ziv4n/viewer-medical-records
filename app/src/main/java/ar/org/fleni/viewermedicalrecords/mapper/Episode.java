package ar.org.fleni.viewermedicalrecords.mapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ar.org.fleni.viewermedicalrecords.R;
import ar.org.fleni.viewermedicalrecords.commons.Constant;

/**
 * Created by ivlopez on 19/09/2016.
 */
public class Episode implements Serializable {

    /**
     * Numero de Episodio
     */
    private String episodeNumber;

    /**
     * Tipo de Episodio
     */
    private String type;

    /**
     * Ambito de Episodio
     */
    private String scope;

    /**
     * Fecha de Ingreso
     */
    private String dateAdmission;

    /**
     * Fecha de Alta
     */
    private String dateDischarge;

    /**
     * Condicion de Egreso
     */
    private String dischargeDisposition;

    /**
     * Ubicacion al Alta
     */
    private String dischargeLocation;

    /**
     * Drawable image
     */
    private int image;

    /**
     * List Document
     */
    private List<Document> documentList;

    /**
     * @param episodeNumber        type String
     * @param type                 type String
     * @param scope                type String
     * @param dateAdmission        type String
     * @param dateDischarge        type String
     * @param dischargeDisposition type String
     * @param dischargeLocation    type String
     */
    public Episode(String episodeNumber, String type, String scope, String dateAdmission, String dateDischarge, String dischargeDisposition, String dischargeLocation, List<Document> documentList) {
        this.episodeNumber = episodeNumber;
        this.type = type;
        this.scope = scope;
        this.dateAdmission = dateAdmission;
        this.dateDischarge = dateDischarge;
        this.dischargeDisposition = dischargeDisposition;
        this.dischargeLocation = dischargeLocation;
        this.image = drawableImage(type);
        this.documentList = documentList;
    }

    /**
     * @param type type String
     * @return int
     */
    private int drawableImage(String type) {
        if (Constant.EPISODE_TYPE_H.equals(type))
            return R.drawable.ic_hospitalization;
        if (Constant.EPISODE_TYPE_C.equals(type))
            return R.drawable.ic_consultation;
        if (Constant.EPISODE_TYPE_U.equals(type))
            return R.drawable.ic_urgency;
        return 0;
    }

    /**
     * @return String
     */
    public String getEpisodeNumber() {
        return episodeNumber;
    }

    /**
     * @param episodeNumber type String
     */
    public void setEpisodeNumber(String episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    /**
     * @return String
     */
    public String getType() {
        return type;
    }

    /**
     * @param type type String
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return String
     */
    public String getScope() {
        return scope;
    }

    /**
     * @param scope type String
     */
    public void setScope(String scope) {
        this.scope = scope;
    }

    /**
     * @return String
     */
    public String getDateAdmission() {
        return dateAdmission;
    }

    /**
     * @param dateAdmission type String
     */
    public void setDateAdmission(String dateAdmission) {
        this.dateAdmission = dateAdmission;
    }

    /**
     * @return String
     */
    public String getDateDischarge() {
        return dateDischarge;
    }

    /**
     * @param dateDischarge type String
     */
    public void setDateDischarge(String dateDischarge) {
        this.dateDischarge = dateDischarge;
    }

    /**
     * @return String
     */
    public String getDischargeDisposition() {
        return dischargeDisposition;
    }

    /**
     * @param dischargeDisposition type String
     */
    public void setDischargeDisposition(String dischargeDisposition) {
        this.dischargeDisposition = dischargeDisposition;
    }

    /**
     * @return String
     */
    public String getDischargeLocation() {
        return dischargeLocation;
    }

    /**
     * @param dischargeLocation type String
     */
    public void setDischargeLocation(String dischargeLocation) {
        this.dischargeLocation = dischargeLocation;
    }

    /**
     * @return int
     */
    public int getImage() {
        return image;
    }

    /**
     * @param image type int
     */
    public void setImage(int image) {
        this.image = image;
    }

    /**
     * @return List
     */
    public List<Document> getDocumentList() {
        return documentList;
    }

    /**
     * @param documentList type List
     */
    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }

    /**
     * @param document type Document
     */
    public void addDocumentList(Document document) {
        if (documentList == null) {
            documentList = new ArrayList<>();
        }
        documentList.add(document);
    }
}
