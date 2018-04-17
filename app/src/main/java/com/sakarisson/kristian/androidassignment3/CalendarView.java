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

import java.text.DateFormatSymbols;
import java.util.Calendar;

public final class CalendarView extends View {
    private Bitmap background;
    private Calendar mCalendar;
    private int minSize = 500;

    public CalendarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mCalendar = Calendar.getInstance();
        background = BitmapFactory.decodeResource(context.getResources(), R.drawable.calendar_sheet);
    }

    // Get the name of the month from Calendar.MONTH
    // https://stackoverflow.com/a/14832267/8857465
    private String getMonthFromInt(int number) {
        String month = "";
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        if (number >= 1 && number <= 12 ) {
            month = months[number - 1];
        }
        return month;
    }

    private String getDayOfWeekFromInt(int number) {
        String day = "";
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] days = dfs.getWeekdays();
        if (number >= 1 && number <= 7 ) {
            day = days[number - 1];
        }
        return day;
    }

    private Bitmap generateScaledBackground(int width, int height) {
        Bitmap scaledBackground = Bitmap.createScaledBitmap(background, width, height, true);
        return scaledBackground;
    }

    private void drawMonthText(Canvas canvas, String text) {
        TextPaint textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.LINEAR_TEXT_FLAG);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(Color.parseColor("#f7faff"));
        textPaint.setTextSize(70);
        canvas.drawText(text, canvas.getWidth() / 2 - textPaint.measureText(text) / 2, canvas.getHeight() / 2 + textPaint.getTextSize() / 2 - 120, textPaint);
    }

    private void drawDayNumberText(Canvas canvas, int number) {
        String text = String.valueOf(number);
        TextPaint textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.LINEAR_TEXT_FLAG);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(Color.parseColor("#000000"));
        textPaint.setTextSize(150);
        canvas.drawText(text, canvas.getWidth() / 2 - textPaint.measureText(text) / 2, canvas.getHeight() / 2 + textPaint.getTextSize() / 2, textPaint);
    }

    private void drawDayOfWeekText(Canvas canvas, String text) {
        TextPaint textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.LINEAR_TEXT_FLAG);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(Color.parseColor("#000000"));
        textPaint.setTextSize(50);
        canvas.drawText(text, canvas.getWidth() / 2 - textPaint.measureText(text) / 2, canvas.getHeight() / 2 + textPaint.getTextSize() / 2 + 120, textPaint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.LTGRAY);
        canvas.drawBitmap(generateScaledBackground(canvas.getWidth(), canvas.getHeight()), 0, 0, null);

        TextPaint test = new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.LINEAR_TEXT_FLAG);
        test.setColor(Color.parseColor("#ff00ff"));
        test.setTextSize(30);
        drawMonthText(canvas, getMonthFromInt(mCalendar.MONTH));
        drawDayNumberText(canvas, mCalendar.DAY_OF_MONTH);
        drawDayOfWeekText(canvas, getDayOfWeekFromInt(mCalendar.DAY_OF_WEEK));
    }
}
