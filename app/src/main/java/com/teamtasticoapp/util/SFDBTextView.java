package com.teamtasticoapp.util;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by mahesh on 27/1/17.
 * SanFranciscoDisplay-Regular font TextView
 */

public class SFDBTextView extends android.support.v7.widget.AppCompatTextView {
    public SFDBTextView(Context context) {
        super(context);
        createFont();
    }

    public SFDBTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        createFont();
    }

    public SFDBTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        createFont();
    }

    public void createFont() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/SourceSansPro-Bold.otf");
        setTypeface(font);
    }

}
