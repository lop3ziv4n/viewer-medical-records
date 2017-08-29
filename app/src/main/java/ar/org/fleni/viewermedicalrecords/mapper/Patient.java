package ar.org.fleni.viewermedicalrecords.mapper;

import java.io.Serializable;

/**
 * Created by ivlopez on 19/09/2016.
 */
public class Patient implements Serializable {

    /**
     * Numero de Historia Clinica
     */
    private String patientNumber;

    /**
     * Tipo de Documento
     */
    private String typeDocument;

    /**
     * Numero de Documento
     */
    private String numberDocument;

    /**
     * Domicilio del Paciente
     */
    private Address address;

    /**
     * Telefono del Paciente
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
     * Sexo
     */
    private String sexType;

    /**
     * Fecha de Nacimiento
     */
    private String birthTime;

    /**
     * @param patientNumber  type String
     * @param typeDocument   type String
     * @param numberDocument type String
     * @param address        type Address
     * @param telephone      type String
     * @param surname        type String
     * @param surname2       type String
     * @param name           type String
     * @param name2          type String
     * @param sexType        type String
     * @param birthTime      type String
     */
    public Patient(String patientNumber, String typeDocument, String numberDocument, Address address, String telephone, String surname, String surname2, String name, String name2, String sexType, String birthTime) {
        this.patientNumber = patientNumber;
        this.typeDocument = typeDocument;
        this.numberDocument = numberDocument;
        this.address = address;
        this.telephone = telephone;
        this.surname = surname;
        this.surname2 = surname2;
        this.name = name;
        this.name2 = name2;
        this.sexType = sexType;
        this.birthTime = birthTime;
    }

    /**
     * @return String
     */
    public String getPatientNumber() {
        return patientNumber;
    }

    /**
     * @param patientNumber type String
     */
    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    /**
     * @return String
     */
    public String getTypeDocument() {
        return typeDocument;
    }

    /**
     * @param typeDocument type String
     */
    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    /**
     * @return String
     */
    public String getNumberDocument() {
        return numberDocument;
    }

    /**
     * @param numberDocument type String
     */
    public void setNumberDocument(String numberDocument) {
        this.numberDocument = numberDocument;
    }

    /**
     * @return Address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address type Address
     */
    public void setAddress(Address address) {
        this.address = address;
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

    /**
     * @return String
     */
    public String getSexType() {
        return sexType;
    }

    /**
     * @param sexType type String
     */
    public void setSexType(String sexType) {
        this.sexType = sexType;
    }

    /**
     * @return String
     */
    public String getBirthTime() {
        return birthTime;
    }

    /**
     * @param birthTime type String
     */
    public void setBirthTime(String birthTime) {
        this.birthTime = birthTime;
    }
}
