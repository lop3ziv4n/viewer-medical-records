package ar.org.fleni.viewermedicalrecords.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ar.org.fleni.viewermedicalrecords.R;
import ar.org.fleni.viewermedicalrecords.adapter.EpisodeAdapter;
import ar.org.fleni.viewermedicalrecords.adapter.dto.EpisodeDTO;
import ar.org.fleni.viewermedicalrecords.commons.Constant;
import ar.org.fleni.viewermedicalrecords.mapper.Episode;

/**
 * Created by ivlopez on 23/09/2016.
 */
public class EpisodeListFragment extends ComponentListFragment {

    // Debugging
    private static final String TAG = "EpisodeListFragment";

    private EpisodeAdapter mEpisodeAdapter;
    private EpisodeDTO mEpisodeDTO;

    /**
     *
     */
    public EpisodeListFragment() {
        super();
    }

    /**
     * @param episodeDTO type EpisodeDTO
     * @return EpisodeListFragment
     */
    public static EpisodeListFragment newInstance(EpisodeDTO episodeDTO) {
        Log.d(TAG, "Init: Fragment");
        EpisodeListFragment fragment = new EpisodeListFragment();
        Bundle args = new Bundle();
        args.putSerializable(Constant.ARG_EPISODE_LIST, episodeDTO);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * @return Adapter
     */
    @Override
    protected Adapter getAdapter() {
        Log.d(TAG, "Setting: Initialize Adapter - Factory Data");
        mEpisodeDTO = (EpisodeDTO) getArguments().getSerializable(Constant.ARG_EPISODE_LIST);
        mEpisodeAdapter = new EpisodeAdapter(mEpisodeDTO.getEpisodeList());
        return mEpisodeAdapter;
    }

    /**
     * @param query type String
     */
    @Override
    protected void setAdapterFilter(String query) {
        Log.d(TAG, "Setting: Filter Adapter");
        if (query == null) {
            mEpisodeAdapter.setFilter(mEpisodeDTO.getEpisodeList());
        } else {
            final List<Episode> filteredModelList = filter(query);
            mEpisodeAdapter.setFilter(filteredModelList);
        }
    }

    /**
     * @param position type int
     */
    @Override
    protected void initFragmentChild(int position) {
        Log.d(TAG, "Init: Fragment child");
        Fragment fragment = EpisodePagerFragment.newInstance((Episode) mEpisodeAdapter.getItem(position));
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager
                .beginTransaction()
                .remove(this)
                .replace(R.id.main_content, fragment)
                .commit();
    }

    /**
     * @return int
     */
    @Override
    protected int getFragmentTitle() {
        return R.string.episode_fragment_title;
    }

    /**
     * @param query type String
     * @return List
     */
    private List<Episode> filter(String query) {
        query = query.toLowerCase();
        final List<Episode> filteredModelList = new ArrayList<>();
        for (Episode model : mEpisodeDTO.getEpisodeList()) {
            if (model.getEpisodeNumber().toLowerCase().contains(query)) {
                filteredModelList.add(model);
            } else if (model.getDateAdmission().toLowerCase().contains(query)) {
                filteredModelList.add(model);
            } else if (model.getType().toLowerCase().contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }
}
