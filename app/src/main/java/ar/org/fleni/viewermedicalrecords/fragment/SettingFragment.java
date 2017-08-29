package ar.org.fleni.viewermedicalrecords.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ar.org.fleni.viewermedicalrecords.R;

/**
 * Created by ivlopez on 26/09/2016.
 */
public class SettingFragment extends Fragment {

    // Debugging
    private static final String TAG = "SettingFragment";

    /**
     *
     */
    public SettingFragment() {}

    /**
     * @return SettingFragment
     */
    public static SettingFragment newInstance() {
        Log.d(TAG, "Init: Fragment");
        SettingFragment fragment = new SettingFragment();
        return fragment;
    }

    /**
     * @param inflater           type LayoutInflater
     * @param container          type ViewGroup
     * @param savedInstanceState type Bundle
     * @return View
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "View: Fragment");
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        return view;
    }
}
