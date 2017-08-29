package ar.org.fleni.viewermedicalrecords.factory;

import ar.org.fleni.viewermedicalrecords.mapper.Address;
import ar.org.fleni.viewermedicalrecords.mapper.Patient;

/**
 * Created by ivlopez on 23/09/2016.
 */
public class PatientFactory {

    private static PatientFactory factory = new PatientFactory();
    private Patient patient;

    /**
     * @return PatientFactory
     */
    public static PatientFactory getInstance() {
        return factory;
    }

    /**
     *
     */
    private PatientFactory() {
        Address address = new Address("Street 345", "Bs As", "Bs As", "14", "Argentina", "", "2A");
        patient = new Patient("856411", "dni", "12121212", address, "15-1515-1515", "Perez" , "", "Jorge", "", "Man", "15/2/1980");
    }

    /**
     * @return Patient
     */
    public Patient getPatient() {
        return patient;
    }
}
