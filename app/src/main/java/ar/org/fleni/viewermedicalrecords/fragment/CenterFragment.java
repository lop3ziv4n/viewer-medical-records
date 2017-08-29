package ar.org.fleni.viewermedicalrecords.fragment;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ar.org.fleni.viewermedicalrecords.R;
import ar.org.fleni.viewermedicalrecords.adapter.dto.ComponentDTO;
import ar.org.fleni.viewermedicalrecords.commons.Constant;
import ar.org.fleni.viewermedicalrecords.mapper.Center;

/**
 * Created by ivlopez on 19/09/2016.
 */
public class CenterFragment extends ComponentFragment {

    // Debugging
    private static final String TAG = "CenterFragment";

    /**
     *
     */
    public CenterFragment() {
        super();
    }

    /**
     * @param center type Center
     * @return CenterFragment
     */
    public static CenterFragment newInstance(Center center) {
        Log.d(TAG, "Init: Fragment");
        CenterFragment fragment = new CenterFragment();
        Bundle args = new Bundle();
        args.putSerializable(Constant.ARG_CENTER, center);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * @return List
     */
    @Override
    protected List<ComponentDTO> componentFactory() {
        Center center = (Center) getArguments().getSerializable(Constant.ARG_CENTER);
        List<ComponentDTO> componentDTOs = new ArrayList<>();

        Log.d(TAG, "Setting: Center Information");
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.center_fragment_name), center.getName()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.center_fragment_speciality), center.getSpeciality()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.center_fragment_sub_speciality), center.getSubSpeciality()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.center_fragment_section), center.getSection()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.center_fragment_service), center.getService()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.center_fragment_telephone), center.getTelephone()));

        Log.d(TAG, "Setting: Center Address Information");
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.address_fragment_street_address), center.getAddress().getStreetAddressLine()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.address_fragment_state), center.getAddress().getState()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.address_fragment_city), center.getAddress().getCity()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.address_fragment_country), center.getAddress().getCountry()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.address_fragment_county), center.getAddress().getCounty()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.address_fragment_postal_code), center.getAddress().getPostalCode()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.address_fragment_additional_locator), center.getAddress().getAdditionalLocator()));

        return componentDTOs;
    }

    /**
     * @return int
     */
    @Override
    protected int getFragmentTitle() {
        return R.string.center_fragment_title;
    }
}
