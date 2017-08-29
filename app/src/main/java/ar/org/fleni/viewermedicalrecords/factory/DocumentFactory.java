package ar.org.fleni.viewermedicalrecords.factory;

import java.util.ArrayList;
import java.util.List;

import ar.org.fleni.viewermedicalrecords.mapper.Document;
import ar.org.fleni.viewermedicalrecords.mapper.HealthPlan;
import ar.org.fleni.viewermedicalrecords.mapper.MedicalSigner;

/**
 * Created by iv4nlop3z on 29/09/16.
 */
public class DocumentFactory {

    private static DocumentFactory factory = new DocumentFactory();
    private List<Document> documents = new ArrayList<>();

    /**
     * @return DocumentFactory
     */
    public static DocumentFactory getInstance() {
        return factory;
    }

    /**
     *
     */
    private DocumentFactory() {
        HealthPlan healthPlan = new HealthPlan("1-2453-4", "Perez", "Jorge", "1094", "Name HealthPlan", "45000", "Name Organization");
        MedicalSigner medicalSigner = new MedicalSigner("National", "123-456", "Speciality", "Sub Speciality", "4454-4534", "Perez", "", "Jorge", "");

        saveDocument(new Document("123", "ALT", "1", "01/01/2009", medicalSigner, healthPlan, ClinicContentFactory.getInstance().getClinicContents()));
        saveDocument(new Document("123", "INF", "1", "01/01/2009", medicalSigner, healthPlan, ClinicContentFactory.getInstance().getClinicContents()));
        saveDocument(new Document("123", "EVO", "1", "01/01/2009", medicalSigner, healthPlan, ClinicContentFactory.getInstance().getClinicContents()));
        saveDocument(new Document("123", "INI", "1", "01/01/2009", medicalSigner, healthPlan, ClinicContentFactory.getInstance().getClinicContents()));
    }

    /**
     * @param document type Document
     */
    private void saveDocument(Document document) {
        documents.add(document);
    }

    /**
     * @return List
     */
    public List<Document> getDocuments() {
        return documents;
    }
}
