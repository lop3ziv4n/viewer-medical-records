package ar.org.fleni.viewermedicalrecords.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ar.org.fleni.viewermedicalrecords.R;
import ar.org.fleni.viewermedicalrecords.adapter.DocumentAdapter;
import ar.org.fleni.viewermedicalrecords.adapter.dto.DocumentDTO;
import ar.org.fleni.viewermedicalrecords.commons.Constant;
import ar.org.fleni.viewermedicalrecords.mapper.Document;

/**
 * Created by iv4nlop3z on 29/09/16.
 */
public class DocumentListFragment extends ComponentListFragment {

    // Debugging
    private static final String TAG = "DocumentListFragment";

    private DocumentAdapter mDocumentAdapter;
    private DocumentDTO mDocumentDTO;

    /**
     *
     */
    public DocumentListFragment() {
    }

    /**
     * @param documentDTO type DocumentDTO
     * @return DocumentListFragment
     */
    public static DocumentListFragment newInstance(DocumentDTO documentDTO) {
        Log.d(TAG, "Init: Fragment");
        DocumentListFragment fragment = new DocumentListFragment();
        Bundle args = new Bundle();
        args.putSerializable(Constant.ARG_DOCUMENT_LIST, documentDTO);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * @return int
     */
    @Override
    protected int getFragmentTitle() {
        return R.string.document_fragment_title;
    }

    /**
     * @return Adapter
     */
    @Override
    protected Adapter getAdapter() {
        Log.d(TAG, "Setting: Initialize Adapter - Factory Data");
        mDocumentDTO = (DocumentDTO) getArguments().getSerializable(Constant.ARG_DOCUMENT_LIST);
        mDocumentAdapter = new DocumentAdapter(mDocumentDTO.getDocumentList());
        return mDocumentAdapter;
    }

    /**
     * @param query type String
     */
    @Override
    protected void setAdapterFilter(String query) {
        Log.d(TAG, "Setting: Filter Adapter");
        if (query == null) {
            mDocumentAdapter.setFilter(mDocumentDTO.getDocumentList());
        } else {
            final List<Document> filteredModelList = filter(query);
            mDocumentAdapter.setFilter(filteredModelList);
        }
    }

    /**
     * @param position type int
     */
    @Override
    protected void initFragmentChild(int position) {
        Log.d(TAG, "Init: Fragment child");
        Fragment fragment = DocumentPagerFragment.newInstance((Document) mDocumentAdapter.getItem(position));
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager
                .beginTransaction()
                .remove(this)
                .replace(R.id.main_content, fragment)
                .commit();
    }

    /**
     * @param query type String
     * @return List
     */
    private List<Document> filter(String query) {
        query = query.toLowerCase();
        final List<Document> filteredModelList = new ArrayList<>();
        for (Document model : mDocumentDTO.getDocumentList()) {
            if (model.getDocumentNumber().toLowerCase().contains(query)) {
                filteredModelList.add(model);
            } else if (model.getDateCreate().toLowerCase().contains(query)) {
                filteredModelList.add(model);
            } else if (model.getType().toLowerCase().contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }
}
