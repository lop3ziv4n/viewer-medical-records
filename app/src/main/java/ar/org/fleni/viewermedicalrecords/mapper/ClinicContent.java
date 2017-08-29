package ar.org.fleni.viewermedicalrecords.mapper;

import java.io.Serializable;

/**
 * Created by ivlopez on 28/09/2016.
 */

public class ClinicContent implements Serializable {

    /**
     * Seccion
     */
    private String section;

    /**
     * Texto Narrativo correspondiente al contenido clinico del paciente
     */
    private String description;

    /**
     * @param section     type String
     * @param description type String
     */
    public ClinicContent(String section, String description) {
        this.section = section;
        this.description = description;
    }

    /**
     * @return String
     */
    public String getSection() {
        return section;
    }

    /**
     * @param section type String
     */
    public void setSection(String section) {
        this.section = section;
    }

    /**
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description type String
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
