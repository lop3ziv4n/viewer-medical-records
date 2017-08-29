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
import ar.org.fleni.viewermedicalrecords.mapper.Document;

/**
 * Created by ivlopez on 29/09/2016.
 */
public class DocumentAdapter extends RecyclerView.Adapter<DocumentAdapter.ViewHolder> {

    // Debugging
    private static final String TAG = "DocumentAdapter";

    private List<Document> documentList;

    /**
     * @param documentList type List
     */
    public DocumentAdapter(List<Document> documentList) {
        this.documentList = documentList;
    }

    /**
     * @return int
     */
    @Override
    public int getItemCount() {
        return documentList.size();
    }

    /**
     * @param position type int
     * @return Object
     */
    public Object getItem(int position) {
        return documentList.get(position);
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
        Document documentItem = documentList.get(i);
        viewHolder.imageItem.setImageResource(documentItem.getImage());
        viewHolder.txtItem.setText(documentItem.getDocumentNumber());
        viewHolder.txtSubItem.setText(documentItem.getDateCreate());
        viewHolder.txtSubSubItem.setText(documentItem.getType());
    }

    /**
     * @param documentList type List
     */
    public void setFilter(List<Document> documentList){
        this.documentList = new ArrayList<>();
        this.documentList.addAll(documentList);
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
