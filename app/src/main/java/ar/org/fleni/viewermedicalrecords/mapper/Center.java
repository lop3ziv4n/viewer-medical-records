package ar.org.fleni.viewermedicalrecords.mapper;

import java.io.Serializable;

/**
 * Created by ivlopez on 19/09/2016.
 */
public class Center implements Serializable {

    /**
     * Nombre del Centro de Atencion
     */
    private String name;

    /**
     * Seccion
     */
    private String section;

    /**
     * Departamento o Servicio
     */
    private String service;

    /**
     * Especialidad
     */
    private String speciality;

    /**
     * Sub-Especialidad
     */
    private String subSpeciality;

    /**
     * Telefono del Centro de Atencion
     */
    private String telephone;

    /**
     * Direccion del Centro de Atencion
     */
    private Address address;

    /**
     * @param name          type String
     * @param section       type String
     * @param service       type String
     * @param speciality    type String
     * @param subSpeciality type String
     * @param telephone     type String
     * @param address       type Address
     */
    public Center(String name, String section, String service, String speciality, String subSpeciality, String telephone, Address address) {
        this.name = name;
        this.section = section;
        this.service = service;
        this.speciality = speciality;
        this.subSpeciality = subSpeciality;
        this.telephone = telephone;
        this.address = address;
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
    public String getService() {
        return service;
    }

    /**
     * @param service type String
     */
    public void setService(String service) {
        this.service = service;
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
}
