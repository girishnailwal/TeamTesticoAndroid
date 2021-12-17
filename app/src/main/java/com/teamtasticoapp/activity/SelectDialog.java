package com.teamtasticoapp.activity;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.teamtasticoapp.R;
import com.teamtasticoapp.databinding.DialogselectnoofplayerBinding;

/**
 * Created by mobulous55 on 20/6/18.
 */

public class SelectDialog extends Dialog implements View.OnClickListener {

    Context context;
    private LayoutInflater inflater;
    DialogselectnoofplayerBinding binding;


    public SelectDialog(Context context) {
        super(context);
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        binding = DataBindingUtil.inflate(inflater, R.layout.dialogselectnoofplayer, null, false);
        setContentView(binding.getRoot());
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        getWindow().setBackgroundDrawableResource(R.color.cardview_shadow_start_color);
        setCancelable(false);
    }

    @Override
    public void onClick(View view) {

    }
}
