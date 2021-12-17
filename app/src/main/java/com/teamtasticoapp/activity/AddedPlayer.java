package com.teamtasticoapp.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.teamtasticoapp.R;
import com.teamtasticoapp.databinding.ActivityAddedPlayerBinding;

/**
 * Created by mobulous55 on 20/6/18.
 */

public class AddedPlayer extends AppCompatActivity {
    ActivityAddedPlayerBinding binding;
    private String type;

    public static Intent getIntent(Context context, String selected) {
        Intent intent = new Intent(context, AddedPlayer.class);
        intent.putExtra("type", selected);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_added_player);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_added_player);
        if (getIntent() != null) {
            type = (String) getIntent().getSerializableExtra("type");

            if (type.equals("1")) {
                binding.ll1.setVisibility(View.VISIBLE);
            } else {
               // Toast.makeText(getApplicationContext(), "1 Player Selected", Toast.LENGTH_SHORT).show();
            }

            if (type.equals("2")) {
                binding.ll1.setVisibility(View.VISIBLE);
                binding.ll2.setVisibility(View.VISIBLE);
            } else {
               // Toast.makeText(getApplicationContext(), "2 Player Selected", Toast.LENGTH_SHORT).show();
            }

            if (type.equals("3")) {
                binding.ll1.setVisibility(View.VISIBLE);
                binding.ll2.setVisibility(View.VISIBLE);
                binding.ll3.setVisibility(View.VISIBLE);
            } else {
               // Toast.makeText(getApplicationContext(), "3 Player Selected", Toast.LENGTH_SHORT).show();
            }

            if (type.equals("4")) {
                binding.ll1.setVisibility(View.VISIBLE);
                binding.ll2.setVisibility(View.VISIBLE);
                binding.ll3.setVisibility(View.VISIBLE);
                binding.ll4.setVisibility(View.VISIBLE);
            } else {
               // Toast.makeText(getApplicationContext(), "4 Player Selected", Toast.LENGTH_SHORT).show();
            }

            if (type.equals("5")) {
                binding.ll1.setVisibility(View.VISIBLE);
                binding.ll2.setVisibility(View.VISIBLE);
                binding.ll3.setVisibility(View.VISIBLE);
                binding.ll4.setVisibility(View.VISIBLE);
                binding.ll5.setVisibility(View.VISIBLE);

            } else {
               // Toast.makeText(getApplicationContext(), "5 Player Selected", Toast.LENGTH_SHORT).show();
            }

            if (type.equals("6")) {
                binding.ll1.setVisibility(View.VISIBLE);
                binding.ll2.setVisibility(View.VISIBLE);
                binding.ll3.setVisibility(View.VISIBLE);
                binding.ll4.setVisibility(View.VISIBLE);
                binding.ll5.setVisibility(View.VISIBLE);
                binding.ll6.setVisibility(View.VISIBLE);

            } else {
               // Toast.makeText(getApplicationContext(), "6 Player Selected", Toast.LENGTH_SHORT).show();
            }

            if (type.equals("7")) {
                binding.ll1.setVisibility(View.VISIBLE);
                binding.ll2.setVisibility(View.VISIBLE);
                binding.ll3.setVisibility(View.VISIBLE);
                binding.ll4.setVisibility(View.VISIBLE);
                binding.ll5.setVisibility(View.VISIBLE);
                binding.ll6.setVisibility(View.VISIBLE);
                binding.ll7.setVisibility(View.VISIBLE);


            } else {
                // Toast.makeText(getApplicationContext(), "6 Player Selected", Toast.LENGTH_SHORT).show();
            }

            if (type.equals("8")) {
                binding.ll1.setVisibility(View.VISIBLE);
                binding.ll2.setVisibility(View.VISIBLE);
                binding.ll3.setVisibility(View.VISIBLE);
                binding.ll4.setVisibility(View.VISIBLE);
                binding.ll5.setVisibility(View.VISIBLE);
                binding.ll6.setVisibility(View.VISIBLE);
                binding.ll7.setVisibility(View.VISIBLE);
                binding.ll8.setVisibility(View.VISIBLE);


            } else {
                // Toast.makeText(getApplicationContext(), "6 Player Selected", Toast.LENGTH_SHORT).show();
            }


            if (type.equals("9")) {
                binding.ll1.setVisibility(View.VISIBLE);
                binding.ll2.setVisibility(View.VISIBLE);
                binding.ll3.setVisibility(View.VISIBLE);
                binding.ll4.setVisibility(View.VISIBLE);
                binding.ll5.setVisibility(View.VISIBLE);
                binding.ll6.setVisibility(View.VISIBLE);
                binding.ll7.setVisibility(View.VISIBLE);
                binding.ll8.setVisibility(View.VISIBLE);
                binding.ll9.setVisibility(View.VISIBLE);


            } else {
                // Toast.makeText(getApplicationContext(), "6 Player Selected", Toast.LENGTH_SHORT).show();
            }


            if (type.equals("10")) {
                binding.ll1.setVisibility(View.VISIBLE);
                binding.ll2.setVisibility(View.VISIBLE);
                binding.ll3.setVisibility(View.VISIBLE);
                binding.ll4.setVisibility(View.VISIBLE);
                binding.ll5.setVisibility(View.VISIBLE);
                binding.ll6.setVisibility(View.VISIBLE);
                binding.ll7.setVisibility(View.VISIBLE);
                binding.ll8.setVisibility(View.VISIBLE);
                binding.ll9.setVisibility(View.VISIBLE);
                binding.ll10.setVisibility(View.VISIBLE);


            } else {
                // Toast.makeText(getApplicationContext(), "6 Player Selected", Toast.LENGTH_SHORT).show();
            }


            if (type.equals("11")) {
                binding.ll1.setVisibility(View.VISIBLE);
                binding.ll2.setVisibility(View.VISIBLE);
                binding.ll3.setVisibility(View.VISIBLE);
                binding.ll4.setVisibility(View.VISIBLE);
                binding.ll5.setVisibility(View.VISIBLE);
                binding.ll6.setVisibility(View.VISIBLE);
                binding.ll7.setVisibility(View.VISIBLE);
                binding.ll8.setVisibility(View.VISIBLE);
                binding.ll9.setVisibility(View.VISIBLE);
                binding.ll10.setVisibility(View.VISIBLE);
                binding.ll11.setVisibility(View.VISIBLE);


            } else {
                // Toast.makeText(getApplicationContext(), "6 Player Selected", Toast.LENGTH_SHORT).show();
            }

        }
    }

}