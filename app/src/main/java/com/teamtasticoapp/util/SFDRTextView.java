package com.teamtasticoapp.util;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by mahesh on 27/1/17.
 * SanFranciscoDisplay-Regular font TextView
 */

public class SFDRTextView extends android.support.v7.widget.AppCompatTextView {
    public SFDRTextView(Context context) {
        super(context);
        createFont();
    }

    public SFDRTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        createFont();
    }

    public SFDRTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        createFont();
    }

    public void createFont() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/SourceSansPro-Regular.otf");
        setTypeface(font);
    }

}
