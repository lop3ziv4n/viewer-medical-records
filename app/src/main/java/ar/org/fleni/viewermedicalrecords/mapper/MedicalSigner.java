package ar.org.fleni.viewermedicalrecords.mapper;

import java.io.Serializable;

/**
 * Created by ivlopez on 28/09/2016.
 */

public class MedicalSigner implements Serializable {

    /**
     * Tipo de Matricula del Medico
     */
    private String typeMatriculation;

    /**
     * Numero de Matricula del Medico
     */
    private String numberMatriculation;

    /**
     * Especialidad
     */
    private String speciality;

    /**
     * Sub-Especialidad
     */
    private String subSpeciality;

    /**
     * Telefono del Medico
     */
    private String telephone;

    /**
     * Primer Apellido
     */
    private String surname;

    /**
     * Segundo Apellido
     */
    private String surname2;

    /**
     * Primer Nombre
     */
    private String name;

    /**
     * Segundo Nombre
     */
    private String name2;

    /**
     * @param typeMatriculation   type String
     * @param numberMatriculation type String
     * @param speciality          type String
     * @param subSpeciality       type String
     * @param telephone           type String
     * @param surname             type String
     * @param surname2            type String
     * @param name                type String
     * @param name2               type String
     */
    public MedicalSigner(String typeMatriculation, String numberMatriculation, String speciality, String subSpeciality, String telephone, String surname, String surname2, String name, String name2) {
        this.typeMatriculation = typeMatriculation;
        this.numberMatriculation = numberMatriculation;
        this.speciality = speciality;
        this.subSpeciality = subSpeciality;
        this.telephone = telephone;
        this.surname = surname;
        this.surname2 = surname2;
        this.name = name;
        this.name2 = name2;
    }

    /**
     * @return String
     */
    public String getTypeMatriculation() {
        return typeMatriculation;
    }

    /**
     * @param typeMatriculation type String
     */
    public void setTypeMatriculation(String typeMatriculation) {
        this.typeMatriculation = typeMatriculation;
    }

    /**
     * @return String
     */
    public String getNumberMatriculation() {
        return numberMatriculation;
    }

    /**
     * @param numberMatriculation type String
     */
    public void setNumberMatriculation(String numberMatriculation) {
        this.numberMatriculation = numberMatriculation;
    }

    /**
     * @return String
     */
    public String getSpeciality() {
        return speciality;
    }

    /**
     * @param speciality type String
     */
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    /**
     * @return String
     */
    public String getSubSpeciality() {
        return subSpeciality;
    }

    /**
     * @param subSpeciality type String
     */
    public void setSubSpeciality(String subSpeciality) {
        this.subSpeciality = subSpeciality;
    }

    /**
     * @return String
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone type String
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return String
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname type String
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return String
     */
    public String getSurname2() {
        return surname2;
    }

    /**
     * @param surname2 type String
     */
    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }

    /**
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * @param name type String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String
     */
    public String getName2() {
        return name2;
    }

    /**
     * @param name2 type String
     */
    public void setName2(String name2) {
        this.name2 = name2;
    }
}
