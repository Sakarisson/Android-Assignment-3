package com.sakarisson.kristian.androidassignment3;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.View;

public final class CalendarView extends View {
    private Bitmap background;
    public CalendarView(Context context, AttributeSet attrs) {
        super(context, attrs);
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
}
