package ar.org.fleni.viewermedicalrecords.listener;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by ivlopez on 03/10/2016.
 */

public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {

    // Debugging
    private static final String TAG = "RecyclerListener";

    private OnItemClickListener mListener;
    GestureDetector mGestureDetector;

    public interface OnItemClickListener {
        /**
         * @param view type View
         * @param position type int
         */
        void onItemClick(View view, int position);
    }

    /**
     * @param context type Context
     * @param listener type OnItemClickListener
     */
    public RecyclerItemClickListener(Context context, OnItemClickListener listener) {
        Log.d(TAG, "Setting: Event Item Click");
        mListener = listener;
        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });
    }

    /**
     * @param view type RecyclerView
     * @param e type MotionEvent
     * @return boolean
     */
    @Override
    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
        Log.d(TAG, "Setting: Event Intercept Touch");
        View childView = view.findChildViewUnder(e.getX(), e.getY());
        if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
            mListener.onItemClick(childView, view.getChildAdapterPosition(childView));
        }
        return false;
    }

    /**
     * @param view type RecyclerView
     * @param motionEvent type MotionEvent
     */
    @Override
    public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) {
    }

    /**
     * @param disallowIntercept type boolean
     */
    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }
}
