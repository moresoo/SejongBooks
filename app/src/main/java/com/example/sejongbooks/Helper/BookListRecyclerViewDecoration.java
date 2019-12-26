package com.example.sejongbooks.Helper;

import android.app.Activity;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class BookListRecyclerViewDecoration extends RecyclerView.ItemDecoration {
    private int spanCount;
    private int spacing;
    private int outerMargin;

    public BookListRecyclerViewDecoration(Activity mActivity) {
        spanCount = 2;
        spacing = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                8, mActivity.getResources().getDisplayMetrics());
        outerMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                5, mActivity.getResources().getDisplayMetrics());
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int maxCount = parent.getAdapter().getItemCount();
        int position = parent.getChildAdapterPosition(view);
        int column = position % spanCount;
        int row = position / spanCount;
        int lastRow = (maxCount - 1) / spanCount;

        outRect.left = column * spacing / spanCount;
        outRect.right = spacing - (column + 1) * spacing / spanCount;
        outRect.bottom = spacing;

        if (row != lastRow) {
            outRect.bottom = outerMargin;
        }
    }
}
