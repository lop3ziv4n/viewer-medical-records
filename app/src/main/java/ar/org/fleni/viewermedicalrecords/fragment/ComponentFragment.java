package ar.org.fleni.viewermedicalrecords.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ar.org.fleni.viewermedicalrecords.R;
import ar.org.fleni.viewermedicalrecords.adapter.ComponentAdapter;
import ar.org.fleni.viewermedicalrecords.adapter.dto.ComponentDTO;

/**
 * Created by iv4nlop3z on 06/10/16.
 */
public abstract class ComponentFragment extends Fragment {

    private static final String TAG = "ComponentFragment";

    /**
     *
     */
    public ComponentFragment() {
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
        View view = inflater.inflate(R.layout.recycler_list_view, container, false);

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

        return view;
    }

    /**
     * @return List
     */
    protected abstract List<ComponentDTO> componentFactory();

    /**
     * @return int
     */
    protected abstract int getFragmentTitle();
}
