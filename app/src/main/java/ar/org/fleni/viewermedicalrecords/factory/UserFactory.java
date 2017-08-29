package ar.org.fleni.viewermedicalrecords.factory;

import ar.org.fleni.viewermedicalrecords.mapper.User;

/**
 * Created by ivlopez on 12/10/2016.
 */
public class UserFactory {

    private static UserFactory factory = new UserFactory();
    private User user;

    /**
     * @return UserFactory
     */
    public static UserFactory getInstance() {
        return factory;
    }

    /**
     *
     */
    private UserFactory() {
        user = new User("Jorge Perez", "jorge.perez@email.com.ar", "856411", "http://endpoint.com");
    }

    /**
     * @return User
     */
    public User getUser() {
        return user;
    }
}
