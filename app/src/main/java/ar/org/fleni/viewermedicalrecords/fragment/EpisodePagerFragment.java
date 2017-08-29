package ar.org.fleni.viewermedicalrecords.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;

import ar.org.fleni.viewermedicalrecords.R;
import ar.org.fleni.viewermedicalrecords.adapter.SectionPagerAdapter;
import ar.org.fleni.viewermedicalrecords.adapter.dto.DocumentDTO;
import ar.org.fleni.viewermedicalrecords.commons.Constant;
import ar.org.fleni.viewermedicalrecords.mapper.Episode;

/**
 * Created by ivlopez on 28/09/2016.
 */
public class EpisodePagerFragment extends ComponentPagerFragment {

    // Debugging
    private static final String TAG = "EpisodePagerFragment";

    /**
     *
     */
    public EpisodePagerFragment() {
        super();
    }

    /**
     * @param episode type Episode
     * @return EpisodePagerFragment
     */
    public static EpisodePagerFragment newInstance(Episode episode) {
        Log.d(TAG, "Init: Fragment");
        EpisodePagerFragment fragment = new EpisodePagerFragment();
        Bundle args = new Bundle();
        args.putSerializable(Constant.ARG_EPISODE, episode);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * @param viewPager type ViewPager
     */
    @Override
    protected void populateViewPager(ViewPager viewPager) {
        Log.d(TAG, "Setting: Populate View Page");
        SectionPagerAdapter sectionPagerAdapter = new SectionPagerAdapter(getFragmentManager());
        Episode episode = (Episode) getArguments().getSerializable(Constant.ARG_EPISODE);

        Log.d(TAG, "Init: Fragment child");
        sectionPagerAdapter.addFragment(EpisodeFragment.newInstance(episode), getString(R.string.episode_fragment_title));
        sectionPagerAdapter.addFragment(DocumentListFragment.newInstance(new DocumentDTO(episode.getDocumentList())), getString(R.string.document_fragment_title));

        viewPager.setAdapter(sectionPagerAdapter);
    }
}
