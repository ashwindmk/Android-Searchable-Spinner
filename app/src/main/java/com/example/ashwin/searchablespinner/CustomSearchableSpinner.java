package com.example.ashwin.searchablespinner;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

/**
 * Created by ashwin on 15/6/17.
 */

public class CustomSearchableSpinner extends SearchableSpinner {

    public static boolean isCountriesSpinnerOpen = false;

    public CustomSearchableSpinner(Context context) {
        super(context);
    }

    public CustomSearchableSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomSearchableSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (!isCountriesSpinnerOpen) {
                isCountriesSpinnerOpen = true;
                return super.onTouch(v, event);
            }
            isCountriesSpinnerOpen = false;
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                isCountriesSpinnerOpen = false;
            }
        }, 500);
        return true;
    }
}

