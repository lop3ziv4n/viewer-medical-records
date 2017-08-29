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

import ar.org.fleni.viewermedicalrecords.R;
import ar.org.fleni.viewermedicalrecords.manager.SessionManagement;

/**
 * Created by ivlopez on 12/10/2016.
 */

public class LoginActivity extends AppCompatActivity {

    // Debugging
    private static final String TAG = "LoginActivity";

    private EditText txtUsername;
    private EditText txtPassword;

    private View loginFormView;
    private View progressView;

    // User Session Manager Class
    private SessionManagement session;

    private UserLoginTask userLoginTask = null;

    /**
     * @param savedInstanceState type Bundle
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Log.d(TAG, "Setting: User Session Manager");
        session = new SessionManagement(getApplicationContext());

        txtUsername = (EditText) findViewById(R.id.input_username);
        txtPassword = (EditText) findViewById(R.id.input_password);
        loginFormView = findViewById(R.id.login_form);
        progressView = findViewById(R.id.login_progress);

        Log.d(TAG, "User Login Status: " + session.isLoggedIn());

        Button btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                initLogin();
            }
        });
    }

    /**
     * Validate Login form and authenticate.
     */
    public void initLogin() {

        Log.d(TAG, "Setting: Initial Login");
        txtUsername.setError(null);
        txtPassword.setError(null);

        String username = txtUsername.getText().toString();
        String password = txtPassword.getText().toString();

        boolean cancelLogin = false;
        View focusView = null;

        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            txtPassword.setError(getString(R.string.message_invalid_password));
            focusView = txtPassword;
            cancelLogin = true;
        }
        if (TextUtils.isEmpty(username)) {
            txtUsername.setError(getString(R.string.message_field_required));
            focusView = txtUsername;
            cancelLogin = true;
        } else if (!isUsernameValid(username)) {
            txtUsername.setError(getString(R.string.message_invalid_username));
            focusView = txtUsername;
            cancelLogin = true;
        }

        if (cancelLogin) {
            Log.d(TAG, "Error in login");
            focusView.requestFocus();
        } else {
            Log.d(TAG, "Show progress spinner, and start background task to login");
            showProgress(true);
            userLoginTask = new UserLoginTask(username, password);
            userLoginTask.execute((Void) null);
        }
    }

    /**
     * @param username type String
     * @return boolean
     */
    private boolean isUsernameValid(String username) {
        return username.length() > 4;
    }

    /**
     * @param password type String
     * @return boolean
     */
    private boolean isPasswordValid(String password) {
        return password.length() > 4;
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

            loginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            loginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    loginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
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
            loginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    /**
     * Async Login Task to authenticate
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private static final String DUMMY_CREDENTIALS = "jorge;jorge";

        private final String username;
        private final String password;

        /**
         * @param username type String
         * @param password type String
         */
        UserLoginTask(String username, String password) {
            this.username = username;
            this.password = password;
        }

        /**
         * @param params type Void
         * @return Boolean
         */
        @Override
        protected Boolean doInBackground(Void... params) {
            Log.d(TAG, "Setting: UserLoginTask Show Progress");
            // this is where you should write your authentication code
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
            if (pieces[0].equals(username) && pieces[1].equals(password)) {
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
            Log.d(TAG, "Setting: UserLoginTask Post Progress");
            userLoginTask = null;
            //stop the progress spinner
            showProgress(false);

            if (success) {
                Log.d(TAG, "Setting: UserLoginTask login success and move to main Activity here");
                // Starting MainActivity
                Intent intent = new Intent(getApplicationContext(), ConfigActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                // Add new Flag to start new Activity
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

                finish();
            } else {
                Log.d(TAG, "Setting: UserLoginTask login failure");
                txtPassword.setError(getString(R.string.message_incorrect_password));
                txtPassword.requestFocus();
            }
        }

        /**
         *
         */
        @Override
        protected void onCancelled() {
            Log.d(TAG, "Setting: UserLoginTask Cancelled");
            userLoginTask = null;
            showProgress(false);
        }
    }
}

