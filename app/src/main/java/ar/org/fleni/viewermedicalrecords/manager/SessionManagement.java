package ar.org.fleni.viewermedicalrecords.manager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

import ar.org.fleni.viewermedicalrecords.activity.LoginActivity;
import ar.org.fleni.viewermedicalrecords.mapper.User;

/**
 * Created by ivlopez on 12/10/2016.
 */
public class SessionManagement {

    // Debugging
    private static final String TAG = "SessionManagement";

    // Shared Preferences
    private SharedPreferences pref;

    // Editor for Shared preferences
    private Editor editor;

    // Context
    private Context context;

    // Shared pref mode
    private int PRIVATE_MODE = 0;

    // Shared Preferences file name
    private static final String PREF_NAME = "MedicalRecordsPref";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";

    // User name
    private static final String KEY_NAME = "name";

    // Email address
    private static final String KEY_EMAIL = "email";

    // Patient number
    private static final String KEY_PATIENT = "patient";

    // Endpoint
    private static final String KEY_ENDPOINT = "endpoint";

    /**
     * Constructor
     *
     * @param context type Context
     */
    public SessionManagement(Context context) {
        this.context = context;
        pref = this.context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     * Create login session
     *
     * @param user type User
     */
    public void createLoginSession(User user) {
        Log.d(TAG, "Create: Login Session");
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        // Storing name in pref
        editor.putString(KEY_NAME, user.getUsername());

        // Storing email in pref
        editor.putString(KEY_EMAIL, user.getEmail());

        // Storing patient in pref
        editor.putString(KEY_PATIENT, user.getPatientNumber());

        // Storing endpoint in pref
        editor.putString(KEY_ENDPOINT, user.getEndpoint());

        // commit changes
        editor.commit();
    }

    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else do anything
     *
     * @return boolean
     */
    public boolean checkLogin() {
        Log.d(TAG, "Check: Login Session");
        // Check login status
        if (!this.isLoggedIn()) {
            // user is not logged in redirect him to Login Activity
            Intent intent = new Intent(context, LoginActivity.class);
            // Closing all the Activities
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            context.startActivity(intent);

            return true;
        }
        return false;
    }

    /**
     * Get stored session data
     *
     * @return User
     */
    public User getUserDetails() {
        Log.d(TAG, "Get: Login Session");
        User user = new User(pref.getString(KEY_NAME, null),
                pref.getString(KEY_EMAIL, null),
                pref.getString(KEY_PATIENT, null),
                pref.getString(KEY_ENDPOINT, null));

        return user;
    }

    /**
     * Clear session details
     */
    public void logoutUser() {
        Log.d(TAG, "Logout: Login Session");
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to Loing Activity
        Intent intent = new Intent(context, LoginActivity.class);
        // Closing all the Activities
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        context.startActivity(intent);
    }

    /**
     * Quick check for login
     *
     * @return boolean
     */
    public boolean isLoggedIn() {
        Log.d(TAG, "Is: Login Session In");
        // Get Login State
        return pref.getBoolean(IS_LOGIN, false);
    }
}
