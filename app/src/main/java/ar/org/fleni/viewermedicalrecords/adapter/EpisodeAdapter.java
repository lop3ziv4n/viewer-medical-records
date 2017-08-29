package ar.org.fleni.viewermedicalrecords.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ar.org.fleni.viewermedicalrecords.R;
import ar.org.fleni.viewermedicalrecords.mapper.Episode;

/**
 * Created by ivlopez on 23/09/2016.
 */
public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeAdapter.ViewHolder> {

    // Debugging
    private static final String TAG = "EpisodeAdapter";

    private List<Episode> episodeList;

    /**
     * @param episodeList type List
     */
    public EpisodeAdapter(List<Episode> episodeList) {
        this.episodeList = episodeList;
    }

    /**
     * @return int
     */
    @Override
    public int getItemCount() {
        return episodeList.size();
    }

    /**
     * @param position type int
     * @return Object
     */
    public Object getItem(int position) {
        return episodeList.get(position);
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
                .inflate(R.layout.recycler_item, viewGroup, false);
        return new ViewHolder(v);
    }

    /**
     * @param viewHolder type ViewHolder
     * @param i          type int
     */
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Log.d(TAG, "Setting: Bind View Holder");
        Episode episodeItem = episodeList.get(i);
        viewHolder.imageItem.setImageResource(episodeItem.getImage());
        viewHolder.txtItem.setText(episodeItem.getEpisodeNumber());
        viewHolder.txtSubItem.setText(episodeItem.getDateDischarge());
        viewHolder.txtSubSubItem.setText(episodeItem.getType());
    }

    /**
     * @param episodeList type List
     */
    public void setFilter(List<Episode> episodeList){
        this.episodeList = new ArrayList<>();
        this.episodeList.addAll(episodeList);
        notifyDataSetChanged();
    }

    /**
     *
     */
    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageItem;
        TextView txtItem;
        TextView txtSubItem;
        TextView txtSubSubItem;

        /**
         * @param v type View
         */
        ViewHolder(View v) {
            super(v);
            imageItem = (ImageView) v.findViewById(R.id.item_image);
            txtItem = (TextView) v.findViewById(R.id.item_text);
            txtSubItem = (TextView) v.findViewById(R.id.sub_item_text);
            txtSubSubItem = (TextView) v.findViewById(R.id.sub_sub_item_text);
        }
    }
}
