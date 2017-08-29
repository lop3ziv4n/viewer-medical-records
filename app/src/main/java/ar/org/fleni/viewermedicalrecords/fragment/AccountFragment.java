package ar.org.fleni.viewermedicalrecords.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ar.org.fleni.viewermedicalrecords.R;
import ar.org.fleni.viewermedicalrecords.adapter.ComponentAdapter;
import ar.org.fleni.viewermedicalrecords.adapter.dto.ComponentDTO;
import ar.org.fleni.viewermedicalrecords.commons.Constant;
import ar.org.fleni.viewermedicalrecords.manager.SessionManagement;
import ar.org.fleni.viewermedicalrecords.mapper.User;

/**
 * Created by iv4nlop3z on 13/10/16.
 */
public class AccountFragment extends Fragment {

    // Debugging
    private static final String TAG = "AccountFragment";

    // User Session Manager Class
    private SessionManagement session;

    /**
     *
     */
    public AccountFragment() {
        super();
    }

    /**
     * @param user type User
     * @return AccountFragment
     */
    public static AccountFragment newInstance(User user) {
        Log.d(TAG, "Init: Fragment");
        AccountFragment fragment = new AccountFragment();
        Bundle args = new Bundle();
        args.putSerializable(Constant.ARG_ACCOUNT, user);
        fragment.setArguments(args);
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
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        Log.d(TAG, "Setting: TextView Title");
        TextView txtTitle = (TextView) view.findViewById(R.id.recycler_view_title);
        txtTitle.setText(this.getFragmentTitle());

        Log.d(TAG, "Setting: Instant RecyclerView");
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLinearLayoutManager);

        Log.d(TAG, "Setting: Initialize Adapter - Factory Data");
        ComponentAdapter componentAdapter = new ComponentAdapter(this.componentFactory());
        recyclerView.setAdapter(componentAdapter);

        Log.d(TAG, "Session class instance");
        session = new SessionManagement(view.getContext());

        Button btnLogout = (Button) view.findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Logout: Clear the session data");
                session.logoutUser();
            }
        });

        return view;
    }


    /**
     * @return List
     */
    protected List<ComponentDTO> componentFactory() {
        User user = (User) getArguments().getSerializable(Constant.ARG_ACCOUNT);
        List<ComponentDTO> componentDTOs = new ArrayList<>();

        Log.d(TAG, "Setting: User Information");
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.account_fragment_name), user.getUsername()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.account_fragment_email), user.getEmail()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.account_fragment_medical_records_number), user.getPatientNumber()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.account_fragment_endpoint), user.getEndpoint()));

        return componentDTOs;
    }

    /**
     * @return int
     */
    protected int getFragmentTitle() {
        return R.string.account_fragment_title;
    }
}
