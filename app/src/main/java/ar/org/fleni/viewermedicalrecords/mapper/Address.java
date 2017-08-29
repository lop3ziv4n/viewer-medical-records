package ar.org.fleni.viewermedicalrecords.mapper;

import java.io.Serializable;

/**
 * Created by ivlopez on 19/09/2016.
 */
public class Address implements Serializable {

    /**
     * Domicilio (Calle/Nro/Depto)
     */
    private String streetAddressLine;

    /**
     * Ciudad
     */
    private String city;

    /**
     * Provincia
     */
    private String state;

    /**
     * Codigo Postal
     */
    private String postalCode;

    /**
     * Pais
     */
    private String country;

    /**
     * Partido
     */
    private String county;

    /**
     * Departamento
     */
    private String additionalLocator;

    /**
     * @param streetAddressLine type String
     * @param city              type String
     * @param state             type String
     * @param postalCode        type String
     * @param country           type String
     * @param county            type String
     * @param additionalLocator type String
     */
    public Address(String streetAddressLine, String city, String state, String postalCode, String country, String county, String additionalLocator) {
        this.streetAddressLine = streetAddressLine;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.county = county;
        this.additionalLocator = additionalLocator;
    }

    /**
     * @return String
     */
    public String getStreetAddressLine() {
        return streetAddressLine;
    }

    /**
     * @param streetAddressLine type String
     */
    public void setStreetAddressLine(String streetAddressLine) {
        this.streetAddressLine = streetAddressLine;
    }

    /**
     * @return String
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city type String
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return String
     */
    public String getState() {
        return state;
    }

    /**
     * @param state type String
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return String
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode type String
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return String
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country type String
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return String
     */
    public String getCounty() {
        return county;
    }

    /**
     * @param county type String
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * @return String
     */
    public String getAdditionalLocator() {
        return additionalLocator;
    }

    /**
     * @param additionalLocator type String
     */
    public void setAdditionalLocator(String additionalLocator) {
        this.additionalLocator = additionalLocator;
    }
}
