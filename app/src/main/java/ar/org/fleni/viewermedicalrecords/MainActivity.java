package ar.org.fleni.viewermedicalrecords;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import ar.org.fleni.viewermedicalrecords.adapter.dto.DocumentDTO;
import ar.org.fleni.viewermedicalrecords.adapter.dto.EpisodeDTO;
import ar.org.fleni.viewermedicalrecords.factory.CenterFactory;
import ar.org.fleni.viewermedicalrecords.factory.DocumentFactory;
import ar.org.fleni.viewermedicalrecords.factory.EpisodeFactory;
import ar.org.fleni.viewermedicalrecords.factory.PatientFactory;
import ar.org.fleni.viewermedicalrecords.fragment.AccountFragment;
import ar.org.fleni.viewermedicalrecords.fragment.CenterFragment;
import ar.org.fleni.viewermedicalrecords.fragment.DocumentListFragment;
import ar.org.fleni.viewermedicalrecords.fragment.EpisodeListFragment;
import ar.org.fleni.viewermedicalrecords.fragment.HomeFragment;
import ar.org.fleni.viewermedicalrecords.fragment.PatientFragment;
import ar.org.fleni.viewermedicalrecords.fragment.SettingFragment;
import ar.org.fleni.viewermedicalrecords.manager.SessionManagement;
import ar.org.fleni.viewermedicalrecords.mapper.Patient;

/**
 * Created by ivlopez on 12/09/2016.
 */
public class MainActivity extends AppCompatActivity {

    // Debugging
    private static final String TAG = "MainActivity";

    private DrawerLayout drawerLayout;

    // User Session Manager Class
    private SessionManagement session;

    /**
     * @param savedInstanceState type Bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Session class instance");
        session = new SessionManagement(getApplicationContext());

        // If User is not logged in , This will redirect user to LoginActivity
        // and finish current activity from activity stack.
        Log.d(TAG, "Check user login");
        if(session.checkLogin())
            finish();

        Log.d(TAG, "Setting: toolbar");
        settingToolbar();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        Log.d(TAG, "Setting: header");
        settingHeader();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            Log.d(TAG, "Setting: navigation view");
            setupDrawerContent(navigationView);
            Log.d(TAG, "Setting: Select item home");
            selectItem(navigationView.getMenu().getItem(0));
        }
    }

    /**
     *
     */
    private void settingToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            Log.d(TAG, "Setting icon drawer toggle");
            ab.setHomeAsUpIndicator(R.drawable.ic_menu);
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     *
     */
    private void settingHeader() {
        TextView username = (TextView) findViewById(R.id.header_username);
        TextView patientNumber = (TextView) findViewById(R.id.header_number_patient);

        Patient patient = PatientFactory.getInstance().getPatient();
        username.setText(patient.getSurname() + " " + patient.getName());
        patientNumber.setText(patient.getPatientNumber());
    }

    /**
     * @param navigationView type NavigationView
     */
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);

                        Log.d(TAG, "Setting: Navigation select item");
                        selectItem(menuItem);

                        drawerLayout.closeDrawers();
                        return true;
                    }
                }
        );
    }

    /**
     * @param menuItem type MenuItem
     */
    private void selectItem(MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.item_home:
                Log.d(TAG, "Init: Home Fragment");
                initFragment(HomeFragment.newInstance());
                break;
            case R.id.item_patient:
                Log.d(TAG, "Init: Patient Fragment");
                initFragment(PatientFragment.newInstance(PatientFactory.getInstance().getPatient()));
                break;
            case R.id.item_provider:
                Log.d(TAG, "Init: Provider Fragment");
                initFragment(CenterFragment.newInstance(CenterFactory.getInstance().getCenter()));
                break;
            case R.id.item_episode:
                Log.d(TAG, "Init: Episode Fragment");
                initFragment(EpisodeListFragment.newInstance(new EpisodeDTO(EpisodeFactory.getInstance().getEpisodes())));
                break;
            case R.id.item_document:
                Log.d(TAG, "Init: Document Fragment");
                initFragment(DocumentListFragment.newInstance(new DocumentDTO(DocumentFactory.getInstance().getDocuments())));
                break;
            case R.id.item_account:
                Log.d(TAG, "Init: Account Fragment");
                initFragment(AccountFragment.newInstance(session.getUserDetails()));
                break;
            case R.id.item_setting:
                Log.d(TAG, "Init: Setting Fragment");
                initFragment(SettingFragment.newInstance());
                break;
        }

        Log.d(TAG, "Setting: Title ActionBar");
        getSupportActionBar().setTitle(menuItem.getTitle());
    }

    /**
     * @param fragment type Fragment
     */
    private void initFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.main_content, fragment)
                .commit();
    }

    /**
     *
     */
    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    /**
     * @param item type MenuItem
     * @return boolean
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
