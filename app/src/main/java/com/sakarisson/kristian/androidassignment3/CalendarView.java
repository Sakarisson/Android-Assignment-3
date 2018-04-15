package com.sakarisson.kristian.androidassignment3;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Calendar;

public final class CalendarView extends View {
    private Bitmap background;
    private Calendar mCalendar;

    public CalendarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mCalendar = Calendar.getInstance();
        mCalendar.add(Calendar.DAY_OF_MONTH, 1);
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

    private Bitmap generateScaledImage(int width, int height) {
        Bitmap scaledBackground = Bitmap.createScaledBitmap(background, width, height, true);
        return scaledBackground;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.LTGRAY);
        canvas.drawBitmap(generateScaledImage(canvas.getWidth(), canvas.getHeight()), 0, 0, null);
        // Get text dimensions
        TextPaint textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.LINEAR_TEXT_FLAG);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(Color.parseColor("#ff00ff"));
        textPaint.setTextSize(30);

        StaticLayout mTextLayout = new StaticLayout("hello", textPaint, 100, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        mTextLayout.draw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec, widthMeasureSpec);
    }
}
