package ar.org.fleni.viewermedicalrecords.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ar.org.fleni.viewermedicalrecords.R;

/**
 * Created by ivlopez on 14/10/2016.
 */
public abstract class ComponentPagerFragment extends Fragment {

    // Debugging
    private static final String TAG = "ComponentPagerFragment";

    private AppBarLayout mAppBarLayout;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    /**
     *
     */
    public ComponentPagerFragment() {
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
        View view = inflater.inflate(R.layout.view_pager_section, container, false);
        View viewParent = (View) container.getParent();

        if (view != null && viewParent != null) {
            mViewPager = (ViewPager) view.findViewById(R.id.view_pager);
            mAppBarLayout = (AppBarLayout) viewParent.findViewById(R.id.appbar);
            mTabLayout = new TabLayout(getActivity());
        }

        return view;
    }

    /**
     * @param view               type View
     * @param savedInstanceState type Bundle
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.d(TAG, "Setting: Add TabLayout");
        mTabLayout.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF"));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mAppBarLayout.addView(mTabLayout);

        Log.d(TAG, "Setting: Adapter View Pager ");
        populateViewPager(mViewPager);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    /**
     *
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mAppBarLayout.removeView(mTabLayout);
    }

    /**
     * @param viewPager type ViewPager
     */
    protected abstract void populateViewPager(ViewPager viewPager);
}
