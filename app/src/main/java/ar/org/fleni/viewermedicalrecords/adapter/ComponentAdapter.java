package ar.org.fleni.viewermedicalrecords.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ar.org.fleni.viewermedicalrecords.R;
import ar.org.fleni.viewermedicalrecords.adapter.dto.ComponentDTO;

/**
 * Created by ivlopez on 05/10/2016.
 */

public class ComponentAdapter extends RecyclerView.Adapter<ComponentAdapter.ViewHolder> {

    // Debugging
    private static final String TAG = "ComponentAdapter";

    private List<ComponentDTO> componentList;

    /**
     * @param componentList type List
     */
    public ComponentAdapter(List<ComponentDTO> componentList) {
        this.componentList = componentList;
    }

    /**
     * @return int
     */
    @Override
    public int getItemCount() {
        return componentList.size();
    }

    /**
     * @param position type int
     * @return Object
     */
    public Object getItem(int position) {
        return componentList.get(position);
    }

    /**
     * @param viewGroup type ViewGroup
     * @param i         type int
     * @return ViewHolder
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Log.d(TAG, "Setting: Create View Holder");
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_item_component, viewGroup, false);
        return new ViewHolder(v);
    }

    /**
     * @param viewHolder type ViewHolder
     * @param i          type int
     */
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Log.d(TAG, "Setting: Bind View Holder");
        ComponentDTO componentItem = componentList.get(i);
        viewHolder.txtTitle.setText(componentItem.getTitle());
        viewHolder.txtDetail.setText(componentItem.getDetail());
    }

    /**
     *
     */
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle;
        TextView txtDetail;

        /**
         * @param v type View
         */
        ViewHolder(View v) {
            super(v);
            txtTitle = (TextView) v.findViewById(R.id.recycler_item_title);
            txtDetail = (TextView) v.findViewById(R.id.recycler_item_detail);
        }
    }
}
