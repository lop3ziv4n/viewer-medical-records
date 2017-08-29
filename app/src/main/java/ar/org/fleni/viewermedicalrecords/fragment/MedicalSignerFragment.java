package ar.org.fleni.viewermedicalrecords.fragment;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ar.org.fleni.viewermedicalrecords.R;
import ar.org.fleni.viewermedicalrecords.adapter.dto.ComponentDTO;
import ar.org.fleni.viewermedicalrecords.commons.Constant;
import ar.org.fleni.viewermedicalrecords.mapper.MedicalSigner;

/**
 * Created by iv4nlop3z on 30/09/16.
 */
public class MedicalSignerFragment extends ComponentFragment {

    // Debugging
    private static final String TAG = "MedicalSignerFragment";

    /**
     *
     */
    public MedicalSignerFragment() {
        super();
    }

    /**
     * @param medicalSigner type MedicalSigner
     * @return MedicalSignerFragment
     */
    public static MedicalSignerFragment newInstance(MedicalSigner medicalSigner) {
        Log.d(TAG, "Init: Fragment");
        MedicalSignerFragment fragment = new MedicalSignerFragment();
        Bundle args = new Bundle();
        args.putSerializable(Constant.ARG_MEDICAL_SIGNER, medicalSigner);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * @return List
     */
    @Override
    protected List<ComponentDTO> componentFactory() {
        MedicalSigner medicalSigner = (MedicalSigner) getArguments().getSerializable(Constant.ARG_MEDICAL_SIGNER);
        List<ComponentDTO> componentDTOs = new ArrayList<>();

        Log.d(TAG, "Setting: Medical Signer Information");
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.medical_signer_fragment_surname), medicalSigner.getSurname() + " " + medicalSigner.getSurname2()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.medical_signer_fragment_name), medicalSigner.getName() + " " + medicalSigner.getName2()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.medical_signer_fragment_type_matriculation), medicalSigner.getTypeMatriculation()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.medical_signer_fragment_number_matriculation), medicalSigner.getNumberMatriculation()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.medical_signer_fragment_speciality), medicalSigner.getSpeciality()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.medical_signer_fragment_sub_speciality), medicalSigner.getSubSpeciality()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.medical_signer_fragment_telephone), medicalSigner.getTelephone()));

        return componentDTOs;
    }

    /**
     * @return int
     */
    @Override
    protected int getFragmentTitle() {
        return R.string.medical_signer_fragment_title;
    }
}
