package ar.org.fleni.viewermedicalrecords.fragment;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ar.org.fleni.viewermedicalrecords.R;
import ar.org.fleni.viewermedicalrecords.adapter.dto.ComponentDTO;
import ar.org.fleni.viewermedicalrecords.commons.Constant;
import ar.org.fleni.viewermedicalrecords.mapper.Document;

/**
 * Created by iv4nlop3z on 30/09/16.
 */
public class DocumentFragment extends ComponentFragment {

    // Debugging
    private static final String TAG = "DocumentFragment";

    /**
     *
     */
    public DocumentFragment() {
        super();
    }

    /**
     * @param document type Document
     * @return DocumentFragment
     */
    public static DocumentFragment newInstance(Document document) {
        Log.d(TAG, "Init: Fragment");
        DocumentFragment fragment = new DocumentFragment();
        Bundle args = new Bundle();
        args.putSerializable(Constant.ARG_DOCUMENT, document);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * @return List
     */
    @Override
    protected List<ComponentDTO> componentFactory() {
        Document document = (Document) getArguments().getSerializable(Constant.ARG_DOCUMENT);
        List<ComponentDTO> componentDTOs = new ArrayList<>();

        Log.d(TAG, "Setting: Document Information");
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.document_fragment_document), document.getDocumentNumber()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.document_fragment_type), document.getType()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.document_fragment_version), document.getVersion()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.document_fragment_date_created), document.getDateCreate()));

        return componentDTOs;
    }

    /**
     * @return int
     */
    @Override
    protected int getFragmentTitle() {
        return R.string.document_fragment_title;
    }
}
