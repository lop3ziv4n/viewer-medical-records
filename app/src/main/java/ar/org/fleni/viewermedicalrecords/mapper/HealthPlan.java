package ar.org.fleni.viewermedicalrecords.mapper;

import java.io.Serializable;

/**
 * Created by ivlopez on 28/09/2016.
 */

public class HealthPlan implements Serializable {

    /**
     * Número de Afiliado
     */
    private String numberAffiliate;

    /**
     * Apellidos del Titular
     */
    private String surnameAffiliate;

    /**
     * Nombres del Titular
     */
    private String nameAffiliate;

    /**
     * Codigo del Plan de Salud
     */
    private String codeHealthPlan;

    /**
     * Nombre del Plan de Salud
     */
    private String nameHealthPlan;

    /**
     * Codigo del Financiador
     */
    private String codeOrganization;

    /**
     * Nombre del Financiador
     */
    private String nameOrganization;

    /**
     * @param numberAffiliate  type String
     * @param surnameAffiliate type String
     * @param nameAffiliate    type String
     * @param codeHealthPlan   type String
     * @param nameHealthPlan   type String
     * @param codeOrganization type String
     * @param nameOrganization type String
     */
    public HealthPlan(String numberAffiliate, String surnameAffiliate, String nameAffiliate, String codeHealthPlan, String nameHealthPlan, String codeOrganization, String nameOrganization) {
        this.numberAffiliate = numberAffiliate;
        this.surnameAffiliate = surnameAffiliate;
        this.nameAffiliate = nameAffiliate;
        this.codeHealthPlan = codeHealthPlan;
        this.nameHealthPlan = nameHealthPlan;
        this.codeOrganization = codeOrganization;
        this.nameOrganization = nameOrganization;
    }

    /**
     * @return String
     */
    public String getNumberAffiliate() {
        return numberAffiliate;
    }

    /**
     * @param numberAffiliate type String
     */
    public void setNumberAffiliate(String numberAffiliate) {
        this.numberAffiliate = numberAffiliate;
    }

    /**
     * @return String
     */
    public String getSurnameAffiliate() {
        return surnameAffiliate;
    }

    /**
     * @param surnameAffiliate type String
     */
    public void setSurnameAffiliate(String surnameAffiliate) {
        this.surnameAffiliate = surnameAffiliate;
    }

    /**
     * @return String
     */
    public String getNameAffiliate() {
        return nameAffiliate;
    }

    /**
     * @param nameAffiliate type String
     */
    public void setNameAffiliate(String nameAffiliate) {
        this.nameAffiliate = nameAffiliate;
    }

    /**
     * @return String
     */
    public String getCodeHealthPlan() {
        return codeHealthPlan;
    }

    /**
     * @param codeHealthPlan type String
     */
    public void setCodeHealthPlan(String codeHealthPlan) {
        this.codeHealthPlan = codeHealthPlan;
    }

    /**
     * @return String
     */
    public String getNameHealthPlan() {
        return nameHealthPlan;
    }

    /**
     * @param nameHealthPlan type String
     */
    public void setNameHealthPlan(String nameHealthPlan) {
        this.nameHealthPlan = nameHealthPlan;
    }

    /**
     * @return String
     */
    public String getCodeOrganization() {
        return codeOrganization;
    }

    /**
     * @param codeOrganization type String
     */
    public void setCodeOrganization(String codeOrganization) {
        this.codeOrganization = codeOrganization;
    }

    /**
     * @return String
     */
    public String getNameOrganization() {
        return nameOrganization;
    }

    /**
     * @param nameOrganization type String
     */
    public void setNameOrganization(String nameOrganization) {
        this.nameOrganization = nameOrganization;
    }
}
