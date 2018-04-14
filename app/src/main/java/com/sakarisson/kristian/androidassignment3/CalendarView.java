package com.sakarisson.kristian.androidassignment3;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public final class CalendarView extends View {
    private Bitmap background;
    private ImageView mImageView;
    private Context mContext;

    public CalendarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CalendarView,
                0, 0
        );
        try {
            background = BitmapFactory.decodeResource(context.getResources(), R.drawable.calendar_sheet);
        } finally {
            a.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.LTGRAY);
        canvas.drawBitmap(background, 0, 0, null);
    }
}
