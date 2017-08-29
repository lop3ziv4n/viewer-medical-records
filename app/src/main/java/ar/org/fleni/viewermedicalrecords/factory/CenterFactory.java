package ar.org.fleni.viewermedicalrecords.factory;

import ar.org.fleni.viewermedicalrecords.mapper.Address;
import ar.org.fleni.viewermedicalrecords.mapper.Center;

/**
 * Created by ivlopez on 23/09/2016.
 */
public class CenterFactory {

    private static CenterFactory factory = new CenterFactory();
    private Center center;

    /**
     * @return CenterFactory
     */
    public static CenterFactory getInstance() {
        return factory;
    }

    /**
     *
     */
    private CenterFactory() {
        Address address = new Address("Street 123", "Bs As", "Bs As", "1578", "Argentina", "Martinez", "1B");
        center = new Center("Center Name", "Section", "Service", "Speciality", "Sub Speciality", "15-1515-1515", address);
    }

    /**
     * @return Center
     */
    public Center getCenter() {
        return center;
    }
}
