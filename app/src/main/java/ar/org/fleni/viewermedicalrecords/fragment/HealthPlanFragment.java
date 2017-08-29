package ar.org.fleni.viewermedicalrecords.fragment;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ar.org.fleni.viewermedicalrecords.R;
import ar.org.fleni.viewermedicalrecords.adapter.dto.ComponentDTO;
import ar.org.fleni.viewermedicalrecords.commons.Constant;
import ar.org.fleni.viewermedicalrecords.mapper.HealthPlan;

/**
 * Created by iv4nlop3z on 30/09/16.
 */
public class HealthPlanFragment extends ComponentFragment {

    // Debugging
    private static final String TAG = "HealthPlanFragment";

    /**
     *
     */
    public HealthPlanFragment() {
        super();
    }

    /**
     * @param healthPlan type HealthPlan
     * @return HealthPlanFragment
     */
    public static HealthPlanFragment newInstance(HealthPlan healthPlan) {
        Log.d(TAG, "Init: Fragment");
        HealthPlanFragment fragment = new HealthPlanFragment();
        Bundle args = new Bundle();
        args.putSerializable(Constant.ARG_HEALTH_PLAN, healthPlan);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * @return List
     */
    @Override
    protected List<ComponentDTO> componentFactory() {
        HealthPlan healthPlan = (HealthPlan) getArguments().getSerializable(Constant.ARG_HEALTH_PLAN);
        List<ComponentDTO> componentDTOs = new ArrayList<>();

        Log.d(TAG, "Setting: HealthPlan Information");
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.health_plan_fragment_number_affiliate), healthPlan.getNumberAffiliate()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.health_plan_fragment_surname_affiliate), healthPlan.getSurnameAffiliate()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.health_plan_fragment_name_affiliate), healthPlan.getNameAffiliate()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.health_plan_fragment_code_health_plan), healthPlan.getCodeHealthPlan()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.health_plan_fragment_name_health_plan), healthPlan.getNameHealthPlan()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.health_plan_fragment_code_organization), healthPlan.getCodeOrganization()));
        componentDTOs.add(new ComponentDTO(getResources().getString(R.string.health_plan_fragment_name_organization), healthPlan.getNameOrganization()));

        return componentDTOs;
    }

    /**
     * @return int
     */
    @Override
    protected int getFragmentTitle() {
        return R.string.health_plan_fragment_title;
    }
}
