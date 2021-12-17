package com.teamtasticoapp.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.teamtasticoapp.R;
import com.teamtasticoapp.databinding.GallaryImagePlaceSendBinding;

import java.io.File;

/**
 * Created by mobulous55 on 3/4/18.
 */

public class GallaryImagePlace extends BaseActivity implements View.OnClickListener {
    GallaryImagePlaceSendBinding binding;
    File fileFlyer;
    String img_path;
    Uri imageUri;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.gallary_image_place_send);

        binding.ivGallary.setOnClickListener(this);
        binding.llSend.setOnClickListener(this);
        binding.ivBackButton.setOnClickListener(this);

        img_path = getIntent().getStringExtra("path");
        imageUri = getIntent().getParcelableExtra("uri");

        fileFlyer = new File(img_path);


        Glide.with(this.getApplicationContext())
                .load(imageUri)
                .centerCrop()
                .into(new SimpleTarget<GlideDrawable>(500, 500) {
                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {

                        binding.ivGallary.setVisibility(View.VISIBLE);
                        binding.ivGallary.setImageDrawable(resource);

                    }

                    @Override
                    public void onLoadFailed(Exception e, Drawable errorDrawable) {
                        super.onLoadFailed(e, errorDrawable);

                    }
                });

    }

    @Override
    public void onClick(View view) {
        if (view == binding.llSend) {
            Intent intent = new Intent(this, IndividualChatDetail.class);
            startActivity(intent);

        } else if (view == binding.ivBackButton) {
            finish();
        }

    }
}
