package ar.org.fleni.viewermedicalrecords.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ar.org.fleni.viewermedicalrecords.R;
import ar.org.fleni.viewermedicalrecords.graphics.DecorationLineDiv;
import ar.org.fleni.viewermedicalrecords.listener.RecyclerItemClickListener;

/**
 * Created by ivlopez on 19/10/2016.
 */
public abstract class ComponentListFragment extends Fragment implements SearchView.OnQueryTextListener {

    private static final String TAG = "ComponentListFragment";

    private RecyclerView mRecyclerView;
    private TextView mTxtTitle;

    /**
     *
     */
    public ComponentListFragment() {
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

        if (view != null) {
            mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
            mTxtTitle = (TextView) view.findViewById(R.id.recycler_view_title);
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

        Log.d(TAG, "Setting: TextView Title");
        mTxtTitle.setText(getFragmentTitle());

        Log.d(TAG, "Setting: RecyclerView Layout");
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        Log.d(TAG, "Setting: RecyclerView Adapter");
        mRecyclerView.setAdapter(getAdapter());

        Log.d(TAG, "Setting: RecyclerView Decoration Line");
        mRecyclerView.addItemDecoration(new DecorationLineDiv(getActivity()));

        Log.d(TAG, "Setting: RecyclerView Touch Listener");
        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Log.d(TAG, "Setting: Event ItemClick");
                        initFragmentChild(position);
                    }
                })
        );
    }

    /**
     * @param savedInstanceState type Bundle
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "Setting: Menu Option");
        setHasOptionsMenu(true);
    }

    /**
     * @param menu     type Menu
     * @param inflater type MenuInflater
     */
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Log.d(TAG, "Setting: Option Menu");
        inflater.inflate(R.menu.main_menu, menu);

        final MenuItem item = menu.findItem(R.id.item_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);

        MenuItemCompat.setOnActionExpandListener(item,
                new MenuItemCompat.OnActionExpandListener() {
                    @Override
                    public boolean onMenuItemActionCollapse(MenuItem item) {
                        Log.d(TAG, "Setting: Do something when collapsed");
                        setAdapterFilter(null);
                        return true;
                    }

                    @Override
                    public boolean onMenuItemActionExpand(MenuItem item) {
                        Log.d(TAG, "Setting: Do something when expanded");
                        return true;
                    }
                });
    }

    /**
     * @param newText type String
     * @return boolean
     */
    @Override
    public boolean onQueryTextChange(String newText) {
        Log.d(TAG, "Setting: Query Text Change");
        setAdapterFilter(newText);
        return true;
    }

    /**
     * @param query type String
     * @return boolean
     */
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    /**
     * @return int
     */
    protected abstract int getFragmentTitle();

    /**
     * @return Adapter
     */
    protected abstract Adapter getAdapter();

    /**
     * @param query type String
     */
    protected abstract void setAdapterFilter(String query);

    /**
     * @param position type int
     */
    protected abstract void initFragmentChild(int position);

}
