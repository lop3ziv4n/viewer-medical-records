package ar.org.fleni.viewermedicalrecords.adapter.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ar.org.fleni.viewermedicalrecords.mapper.Document;

/**
 * Created by iv4nlop3z on 29/09/16.
 */
public class DocumentDTO implements Serializable {

    /**
     * List Document
     */
    private List<Document> documentList = new ArrayList<>();

    /**
     * @param documentList type List
     */
    public DocumentDTO(List<Document> documentList) {
        this.documentList = documentList;
    }

    /**
     * @return List
     */
    public List<Document> getDocumentList() {
        return documentList;
    }

    /**
     * @param documentList type List
     */
    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }
}
