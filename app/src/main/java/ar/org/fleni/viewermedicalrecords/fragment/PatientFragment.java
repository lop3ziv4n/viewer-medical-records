package ar.org.fleni.viewermedicalrecords.fragment;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ar.org.fleni.viewermedicalrecords.R;
import ar.org.fleni.viewermedicalrecords.adapter.dto.ComponentDTO;
import ar.org.fleni.viewermedicalrecords.commons.Constant;
import ar.org.fleni.viewermedicalrecords.mapper.Patient;

/**
 * Created by ivlopez on 19/09/2016.
 */
public class PatientFragment extends ComponentFragment {

    // Debugging
    private static final String TAG = "PatientFragment";

    /**
     *
     */
    public PatientFragment() {
        super();
    }

    /**
     * @param patient type Patient
     * @return PatientFragment
     */
    public static PatientFragment newInstance(Patient patient) {
        Log.d(TAG, "Init: Fragment");
        PatientFragment fragment = new PatientFragment();
        Bundle args = new Bundle();
        args.putSerializable(Constant.ARG_PATIENT, patient);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * @return List
     */
    @Override
    protected List<ComponentDTO> componentFactory() {
        Patient patient = (Patient) getArguments().getSerializable(Constant.ARG_PATIENT);
        List<ComponentDTO> componentDTOs = new ArrayList<>();

        Log.d(TAG, "Setting: Patient Information");
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.patient_fragment_patient), patient.getPatientNumber()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.patient_fragment_document), patient.getTypeDocument() + " " + patient.getNumberDocument()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.patient_fragment_surname), patient.getSurname() + " " + patient.getSurname2()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.patient_fragment_name), patient.getName() + " " + patient.getName2()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.patient_fragment_sex), patient.getSexType()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.patient_fragment_birth_date), patient.getBirthTime()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.patient_fragment_telephone), patient.getTelephone()));

        Log.d(TAG, "Setting: Patient Address Information");
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.address_fragment_street_address), patient.getAddress().getStreetAddressLine()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.address_fragment_state), patient.getAddress().getState()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.address_fragment_city), patient.getAddress().getCity()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.address_fragment_country), patient.getAddress().getCountry()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.address_fragment_county), patient.getAddress().getCounty()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.address_fragment_postal_code), patient.getAddress().getPostalCode()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.address_fragment_additional_locator), patient.getAddress().getAdditionalLocator()));

        return componentDTOs;
    }

    /**
     * @return int
     */
    @Override
    protected int getFragmentTitle() {
        return R.string.patient_fragment_title;
    }
}
