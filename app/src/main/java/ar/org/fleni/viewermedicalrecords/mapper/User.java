package ar.org.fleni.viewermedicalrecords.mapper;

import java.io.Serializable;

/**
 * Created by ivlopez on 12/10/2016.
 */
public class User implements Serializable {

    /**
     * Name and Surname
     */
    private String username;

    /**
     * email
     */
    private String email;

    /**
     * medical records number
     */
    private String patientNumber;

    /**
     * url information patient
     */
    private String endpoint;

    /**
     * @param username      type String
     * @param email         type String
     * @param patientNumber type String
     * @param endpoint      type String
     */
    public User(String username, String email, String patientNumber, String endpoint) {
        this.username = username;
        this.email = email;
        this.patientNumber = patientNumber;
        this.endpoint = endpoint;
    }

    /**
     * @return String
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username type String
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email type String
     */
    public void setEmail(String email) {
        this.email = email;
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
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * @param endpoint type String
     */
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}
