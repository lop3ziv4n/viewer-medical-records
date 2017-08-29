package ar.org.fleni.viewermedicalrecords.mapper;

import java.io.Serializable;
import java.util.List;

import ar.org.fleni.viewermedicalrecords.R;

/**
 * Created by ivlopez on 28/09/2016.
 */

public class Document implements Serializable {

    /**
     * Identificador unico del documento
     */
    private String documentNumber;

    /**
     * Tipo especifico de documento
     */
    private String type;

    /**
     * Version del Documento
     */
    private String version;

    /**
     * Fecha de Creacion del Documento
     */
    private String dateCreate;

    /**
     * Datos del Autor del Documento
     */
    private MedicalSigner medicalSigner;

    /**
     * Numero de Afiliado y Cobertura
     */
    private HealthPlan healthPlan;

    /**
     * Contenido Clinico
     */
    private List<ClinicContent> clinicContents;

    /**
     * Drawable image
     */
    private int image;

    /**
     * @param documentNumber type String
     * @param type           type String
     * @param version        type String
     * @param dateCreate     type String
     * @param medicalSigner  type MedicalSigner
     * @param healthPlan     type HealthPlan
     * @param clinicContents type List
     */
    public Document(String documentNumber, String type, String version, String dateCreate, MedicalSigner medicalSigner, HealthPlan healthPlan, List<ClinicContent> clinicContents) {
        this.documentNumber = documentNumber;
        this.type = type;
        this.version = version;
        this.dateCreate = dateCreate;
        this.medicalSigner = medicalSigner;
        this.healthPlan = healthPlan;
        this.clinicContents = clinicContents;
        this.image = drawableImage(type);
    }

    /**
     * @param type type String
     * @return int
     */
    private int drawableImage(String type) {
        if(!type.isEmpty())
            return R.drawable.ic_file_document;
        return 0;
    }

    /**
     * @return String
     */

    public String getDocumentNumber() {
        return documentNumber;
    }

    /**
     * @param documentNumber type String
     */
    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
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
    public String getVersion() {
        return version;
    }

    /**
     * @param version type String
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * @return String
     */
    public String getDateCreate() {
        return dateCreate;
    }

    /**
     * @param dateCreate type String
     */
    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    /**
     * @return MedicalSigner
     */
    public MedicalSigner getMedicalSigner() {
        return medicalSigner;
    }

    /**
     * @param medicalSigner type MedicalSigner
     */
    public void setMedicalSigner(MedicalSigner medicalSigner) {
        this.medicalSigner = medicalSigner;
    }

    /**
     * @return HealthPlan
     */
    public HealthPlan getHealthPlan() {
        return healthPlan;
    }

    /**
     * @param healthPlan type HealthPlan
     */
    public void setHealthPlan(HealthPlan healthPlan) {
        this.healthPlan = healthPlan;
    }

    /**
     * @return List
     */
    public List<ClinicContent> getClinicContents() {
        return clinicContents;
    }

    /**
     * @param clinicContents type List
     */
    public void setClinicContents(List<ClinicContent> clinicContents) {
        this.clinicContents = clinicContents;
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
}
