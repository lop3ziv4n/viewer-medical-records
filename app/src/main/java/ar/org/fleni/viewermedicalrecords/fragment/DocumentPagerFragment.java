package ar.org.fleni.viewermedicalrecords.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;

import ar.org.fleni.viewermedicalrecords.R;
import ar.org.fleni.viewermedicalrecords.adapter.SectionPagerAdapter;
import ar.org.fleni.viewermedicalrecords.adapter.dto.ClinicContentDTO;
import ar.org.fleni.viewermedicalrecords.commons.Constant;
import ar.org.fleni.viewermedicalrecords.mapper.Document;

/**
 * Created by ivlopez on 03/10/2016.
 */
public class DocumentPagerFragment extends ComponentPagerFragment {

    // Debugging
    private static final String TAG = "DocumentPagerFragment";

    /**
     *
     */
    public DocumentPagerFragment() {
        super();
    }

    /**
     * @param document type Document
     * @return DocumentPagerFragment
     */
    public static DocumentPagerFragment newInstance(Document document) {
        Log.d(TAG, "Init: Fragment");
        DocumentPagerFragment fragment = new DocumentPagerFragment();
        Bundle args = new Bundle();
        args.putSerializable(Constant.ARG_DOCUMENT, document);
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

        Document document = (Document) getArguments().getSerializable(Constant.ARG_DOCUMENT);

        Log.d(TAG, "Init: Fragment child");
        sectionPagerAdapter.addFragment(DocumentFragment.newInstance(document), getString(R.string.document_fragment_title));
        sectionPagerAdapter.addFragment(HealthPlanFragment.newInstance(document.getHealthPlan()), getString(R.string.health_plan_fragment_title));
        sectionPagerAdapter.addFragment(MedicalSignerFragment.newInstance(document.getMedicalSigner()), getString(R.string.medical_signer_fragment_title));
        sectionPagerAdapter.addFragment(ClinicContentFragment.newInstance(new ClinicContentDTO(document.getClinicContents())), getString(R.string.clinic_content_fragment_title));

        viewPager.setAdapter(sectionPagerAdapter);
    }
}
