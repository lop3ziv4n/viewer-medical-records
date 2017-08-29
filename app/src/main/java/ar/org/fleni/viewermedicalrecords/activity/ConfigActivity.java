package ar.org.fleni.viewermedicalrecords.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import ar.org.fleni.viewermedicalrecords.MainActivity;
import ar.org.fleni.viewermedicalrecords.R;
import ar.org.fleni.viewermedicalrecords.factory.UserFactory;
import ar.org.fleni.viewermedicalrecords.manager.SessionManagement;
import ar.org.fleni.viewermedicalrecords.mapper.User;

/**
 * Created by ivlopez on 12/10/2016.
 */
public class ConfigActivity extends AppCompatActivity {

    // Debugging
    private static final String TAG = "ConfigActivity";

    private EditText txtName;
    private EditText txtEmail;
    private EditText txtPatientNumber;
    private EditText txtEndpoint;

    private View configFormView;
    private View progressView;

    // User Session Manager Class
    private SessionManagement session;

    private ConfigurationTask configurationTask = null;

    /**
     * @param savedInstanceState type Bundle
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        Log.d(TAG, "Setting: User Session Manager");
        session = new SessionManagement(getApplicationContext());

        txtName = (EditText) findViewById(R.id.input_name);
        txtEmail = (EditText) findViewById(R.id.input_email);
        txtPatientNumber = (EditText) findViewById(R.id.input_patient_number);
        txtEndpoint = (EditText) findViewById(R.id.input_endpoint);

        configFormView = findViewById(R.id.config_form);
        progressView = findViewById(R.id.config_progress);

        Log.d(TAG, "Setting: Configuration User");
        setTxtConfiguration();

        Log.d(TAG, "User Login Status: " + session.isLoggedIn());
        Button btnConfig = (Button) findViewById(R.id.btn_config);
        btnConfig.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                initConfiguration();
            }
        });
    }

    /**
     *
     */
    private void setTxtConfiguration() {
        User user = UserFactory.getInstance().getUser();
        txtName.setText(user.getUsername());
        txtEmail.setText(user.getEmail());
        txtPatientNumber.setText(user.getPatientNumber());
        txtEndpoint.setText(user.getEndpoint());
    }

    /**
     * Validate configuration form.
     */
    public void initConfiguration() {

        Log.d(TAG, "Setting: Initial Configuration");
        txtName.setError(null);
        txtEmail.setError(null);
        txtPatientNumber.setError(null);
        txtEndpoint.setError(null);

        String name = txtName.getText().toString();
        String email = txtEmail.getText().toString();
        String patient = txtPatientNumber.getText().toString();
        String endpoint = txtEndpoint.getText().toString();

        boolean cancelConfig = false;
        View focusView = null;

        if (TextUtils.isEmpty(patient)) {
            txtPatientNumber.setError(getString(R.string.message_field_required));
            focusView = txtPatientNumber;
            cancelConfig = true;
        }
        if (TextUtils.isEmpty(endpoint)) {
            txtEndpoint.setError(getString(R.string.message_field_required));
            focusView = txtEndpoint;
            cancelConfig = true;
        }

        if (cancelConfig) {
            Log.d(TAG, "Error in Configuration");
            focusView.requestFocus();
        } else {
            Log.d(TAG, "Show progress spinner, and start background task to configuration");
            showProgress(true);
            configurationTask = new ConfigurationTask(name, email, patient, endpoint);
            configurationTask.execute((Void) null);
        }
    }

    /**
     * Shows the progress UI and hides the login form.
     *
     * @param show type boolean
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public void showProgress(final boolean show) {

        Log.d(TAG, "Setting: Show Progress");
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            configFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            configFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    configFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            progressView.setVisibility(show ? View.VISIBLE : View.GONE);
            progressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    progressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            progressView.setVisibility(show ? View.VISIBLE : View.GONE);
            configFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    /**
     * Async Configuration Task
     */
    public class ConfigurationTask extends AsyncTask<Void, Void, Boolean> {

        private static final String DUMMY_CREDENTIALS = "Jorge Perez;jorge.perez@email.com.ar;856411;http://endpoint.com";

        private final String name;
        private final String email;
        private final String patient;
        private final String endpoint;

        /**
         * @param name     type String
         * @param email    type String
         * @param patient  type String
         * @param endpoint type String
         */
        ConfigurationTask(String name, String email, String patient, String endpoint) {
            this.name = name;
            this.email = email;
            this.patient = patient;
            this.endpoint = endpoint;
        }

        /**
         * @param params type Void
         * @return Boolean
         */
        @Override
        protected Boolean doInBackground(Void... params) {
            Log.d(TAG, "Setting: ConfigurationTask Show Progress");
            // this is where you should write your configuration code
            // or call external service
            // following try-catch just simulates network access
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }
            return authenticate();


        }

        /**
         * @return Boolean
         */
        private Boolean authenticate() {
            //using a local dummy credentials store to authenticate
            String[] pieces = DUMMY_CREDENTIALS.split(";");
            if (pieces[0].equals(name) && pieces[1].equals(email) && pieces[2].equals(patient) && pieces[3].equals(endpoint)) {
                return true;
            } else {
                return false;
            }
        }

        /**
         * @param success type Boolean
         */
        @Override
        protected void onPostExecute(final Boolean success) {
            Log.d(TAG, "Setting: ConfigurationTask Post Progress");
            configurationTask = null;
            //stop the progress spinner
            showProgress(false);

            if (success) {
                Log.d(TAG, "Setting: ConfigurationTask Configuration success and move to main Activity here");
                Log.d(TAG, "Setting: ConfigurationTask Creating user login session");
                User user = new User(name, email, patient, endpoint);
                session.createLoginSession(user);

                // Starting MainActivity
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                // Add new Flag to start new Activity
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

                finish();
            } else {
                Log.d(TAG, "Setting: ConfigurationTask Configuration failure");
                txtEndpoint.setError(getString(R.string.message_incorrect_endpoint));
                txtEndpoint.requestFocus();
            }
        }

        /**
         *
         */
        @Override
        protected void onCancelled() {
            Log.d(TAG, "Setting: ConfigurationTask Cancelled");
            configurationTask = null;
            showProgress(false);
        }
    }
}
