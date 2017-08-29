package ar.org.fleni.viewermedicalrecords.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;

import ar.org.fleni.viewermedicalrecords.R;
import ar.org.fleni.viewermedicalrecords.mapper.ClinicContent;

/**
 * Created by ivlopez on 03/10/2016.
 */

public class ClinicContentAdapter extends BaseExpandableListAdapter {

    // Debugging
    private static final String TAG = "ClinicContentAdapter";

    private Context context;
    private List<ClinicContent> clinicContentList;

    /**
     * @param context           type Context
     * @param clinicContentList type List
     */
    public ClinicContentAdapter(Context context, List<ClinicContent> clinicContentList) {
        this.context = context;
        this.clinicContentList = clinicContentList;
    }

    /**
     * @param groupPosition type int
     * @param childPosition type int
     * @return Object
     */
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return clinicContentList.get(groupPosition);
    }

    /**
     * @param groupPosition type int
     * @param childPosition type int
     * @return long
     */
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    /**
     * @param groupPosition type int
     * @return int
     */
    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    /**
     * @param groupPosition type int
     * @param childPosition type int
     * @param isLastChild   type boolean
     * @param view          type View
     * @param parent        type ViewGroup
     * @return View
     */
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                             View view, ViewGroup parent) {

        Log.d(TAG, "Setting: Child View");

        ClinicContent clinicContent = (ClinicContent) getChild(groupPosition, childPosition);
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.expanded_item, null);
        }

        TextView childItem = (TextView) view.findViewById(R.id.expanded_item);
        childItem.setText(clinicContent.getDescription());

        return view;
    }

    /**
     * @param groupPosition type int
     * @return Object
     */
    @Override
    public Object getGroup(int groupPosition) {
        return clinicContentList.get(groupPosition);
    }

    /**
     * @param groupPosition type int
     * @return long
     */
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    /**
     * @return int
     */
    @Override
    public int getGroupCount() {
        return clinicContentList.size();
    }

    /**
     * @param groupPosition type int
     * @param isLastChild   type int
     * @param view          type View
     * @param parent        type ViewGroup
     * @return View
     */
    @Override
    public View getGroupView(int groupPosition, boolean isLastChild, View view,
                             ViewGroup parent) {

        Log.d(TAG, "Setting: Group View");

        ClinicContent clinicContent = (ClinicContent) getGroup(groupPosition);
        if (view == null) {
            LayoutInflater inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inf.inflate(R.layout.expanded_group_item, null);
        }

        TextView heading = (TextView) view.findViewById(R.id.expanded_group_item);
        heading.setText(clinicContent.getSection());

        return view;
    }

    /**
     * @return boolean
     */
    @Override
    public boolean hasStableIds() {
        return true;
    }

    /**
     * @param groupPosition type int
     * @param childPosition type int
     * @return boolean
     */
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
