package ar.org.fleni.viewermedicalrecords.fragment;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ar.org.fleni.viewermedicalrecords.R;
import ar.org.fleni.viewermedicalrecords.adapter.dto.ComponentDTO;
import ar.org.fleni.viewermedicalrecords.commons.Constant;
import ar.org.fleni.viewermedicalrecords.mapper.Episode;

/**
 * Created by ivlopez on 19/09/2016.
 */
public class EpisodeFragment extends ComponentFragment {

    // Debugging
    private static final String TAG = "EpisodeFragment";

    /**
     *
     */
    public EpisodeFragment() {
        super();
    }

    /**
     * @param episode type Episode
     * @return EpisodeFragment
     */
    public static EpisodeFragment newInstance(Episode episode) {
        Log.d(TAG, "Init: Fragment");
        EpisodeFragment fragment = new EpisodeFragment();
        Bundle args = new Bundle();
        args.putSerializable(Constant.ARG_EPISODE, episode);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * @return List
     */
    @Override
    protected List<ComponentDTO> componentFactory() {
        Episode episode = (Episode) getArguments().getSerializable(Constant.ARG_EPISODE);
        List<ComponentDTO> componentDTOs = new ArrayList<>();

        Log.d(TAG, "Setting: Episode Information");
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.episode_fragment_episode), episode.getEpisodeNumber()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.episode_fragment_type), episode.getType()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.episode_fragment_scope), episode.getScope()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.episode_fragment_date_admission), episode.getDateAdmission()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.episode_fragment_date_discharge), episode.getDateDischarge()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.episode_fragment_discharge_disposition), episode.getDischargeDisposition()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.episode_fragment_discharge_location), episode.getDischargeLocation()));

        return componentDTOs;
    }

    /**
     * @return int
     */
    @Override
    protected int getFragmentTitle() {
        return R.string.episode_fragment_title;
    }
}