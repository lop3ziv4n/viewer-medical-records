package ar.org.fleni.viewermedicalrecords.graphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import ar.org.fleni.viewermedicalrecords.R;

/**
 * Created by iv4nlop3z on 29/09/16.
 */

public class DecorationLineDiv extends RecyclerView.ItemDecoration {

    private Drawable mDrawable;

    /**
     * @param context type Context
     */
    public DecorationLineDiv(Context context) {
        mDrawable = ContextCompat.getDrawable(context, R.drawable.line_div);
    }

    /**
     * @param canvas type Canvas
     * @param parent type RecyclerView
     * @param state  type RecyclerView.State
     */
    @Override
    public void onDrawOver(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        int childCount = parent.getChildCount();

        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + mDrawable.getIntrinsicHeight();

            mDrawable.setBounds(left, top, right, bottom);
            mDrawable.draw(canvas);
        }
    }
}
