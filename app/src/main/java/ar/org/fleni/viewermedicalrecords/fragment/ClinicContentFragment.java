package ar.org.fleni.viewermedicalrecords.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ar.org.fleni.viewermedicalrecords.R;
import ar.org.fleni.viewermedicalrecords.adapter.ClinicContentAdapter;
import ar.org.fleni.viewermedicalrecords.adapter.dto.ClinicContentDTO;
import ar.org.fleni.viewermedicalrecords.commons.Constant;
import ar.org.fleni.viewermedicalrecords.mapper.ClinicContent;

/**
 * Created by ivlopez on 03/10/2016.
 */
public class ClinicContentFragment extends Fragment {

    // Debugging
    private static final String TAG = "ClinicContentFragment";

    private List<ClinicContent> mClinicContentList;

    /**
     *
     */
    public ClinicContentFragment() {
    }

    /**
     * @param clinicContentDTO type ClinicContentDTO
     * @return ClinicContentFragment
     */
    public static ClinicContentFragment newInstance(ClinicContentDTO clinicContentDTO) {
        Log.d(TAG, "Init: Fragment");
        ClinicContentFragment fragment = new ClinicContentFragment();
        Bundle args = new Bundle();
        args.putSerializable(Constant.ARG_CLINIC_CONTENT_LIST, clinicContentDTO);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * @param savedInstanceState type Bundle
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        View view = inflater.inflate(R.layout.expandable_list_view, container, false);

        Log.d(TAG, "Setting: TextView Title");
        TextView txtTitle = (TextView) view.findViewById(R.id.expandable_list_view_title);
        txtTitle.setText(R.string.clinic_content_fragment_title);

        Log.d(TAG, "Setting: Instant Expandable ListView");
        ExpandableListView mExpandableListView = (ExpandableListView) view.findViewById(R.id.expandable_list_view);

        Log.d(TAG, "Setting: Initialize Adapter - Factory Data");
        ClinicContentDTO clinicContentDTO = (ClinicContentDTO) getArguments().getSerializable(Constant.ARG_CLINIC_CONTENT_LIST);
        mClinicContentList = clinicContentDTO.getClinicContentList();
        Log.d(TAG, String.valueOf(clinicContentDTO.getClinicContentList().size()));
        ClinicContentAdapter mClinicContentAdapter = new ClinicContentAdapter(getActivity(), mClinicContentList);

        Log.d(TAG, "Setting: Relation List with Adapter");
        mExpandableListView.setAdapter(mClinicContentAdapter);

        Log.d(TAG, "Setting: Listener");
        mExpandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getActivity(),
                        mClinicContentList.get(groupPosition).getSection() + " List Expanded.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        mExpandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getActivity(),
                        mClinicContentList.get(groupPosition).getSection() + " List Collapsed.",
                        Toast.LENGTH_SHORT).show();

            }
        });

        mExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(getActivity(),
                        mClinicContentList.get(childPosition).getDescription(), Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });

        return view;
    }
}
