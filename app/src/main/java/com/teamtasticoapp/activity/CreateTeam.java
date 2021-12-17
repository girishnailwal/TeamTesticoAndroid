package com.teamtasticoapp.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Toast;

import com.teamtasticoapp.R;
import com.teamtasticoapp.databinding.ActivityCreateTeamBinding;

/**
 * Created by mobulous55 on 12/2/18.
 */

public class CreateTeam extends BaseActivity implements View.OnClickListener {
    ActivityCreateTeamBinding binding;
    String edtName;
    boolean isTermsChecked = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_team);

        binding.next.setOnClickListener(this);
        binding.llProfile.setOnClickListener(this);
        binding.llTermAndCondition.setOnClickListener(this);
        binding.llAboutUs.setOnClickListener(this);
    }

    private boolean validateForm() {
        boolean validate = true;//if we don't write this here,then only write below return true;
        edtName = binding.edtName.getText().toString().trim();

        // if string is empty then go inside if part and return false.it will not go below to return validate;
        // it come back to validateForm() and will meet validate=false.so,result returns validate i.e false.
        if (edtName.length() == 0) {
            validate = false; //result of edtName if empty
            Toast.makeText(this, "Please Enter Your Team Name", Toast.LENGTH_SHORT).show();
            //or return false;
        }
        // if string is not empty then return validate means true
        return validate; //result of method validateForm()i.e on success returns validate means true
    }


    @Override
    public void onClick(View view) {

        if (view == binding.next) {

            if (validateForm()) {
                //isTermsChecked is declared true but here in if statement it will meet false bcz,negate.
                //so,it will go inside else part
                if (!isTermsChecked) {
                    Intent intent = new Intent(CreateTeam.this, CreateTeamCoachInfo.class);
                    intent.putExtra("TEAM_NAME", edtName);
                    startActivity(intent);
                } else
                    Toast.makeText(this, "Please Accept Terms & Conditions And Privacy Policies", Toast.LENGTH_SHORT).show();

            }
        } else if (view == binding.llProfile) {

            if (!isTermsChecked) {
                Toast.makeText(this, "Please Complete Profile First", Toast.LENGTH_SHORT).show();
            } else
                Toast.makeText(this, "Please Complete Profile First", Toast.LENGTH_SHORT).show();


        } else if (view == binding.llTermAndCondition) {

            if (validateForm()) {
                if (isTermsChecked) {
                    isTermsChecked = false;
                    binding.imgChecked.setImageResource(R.drawable.checked);
                    //binding.textView.setText(Html.fromHtml("I accept all the" + "<a href='https://teamtastico.com/community/terms/'>Terms &amp; Conditions and\n" +"Privacy Policies</a>"));
                    //binding.textView.setClickable(true);
                    //binding.textView.setMovementMethod(LinkMovementMethod.getInstance());
                    binding.tvTerms.setClickable(true);
                    binding.tvTerms.setMovementMethod(LinkMovementMethod.getInstance());
                    binding.tvTerms.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                            browserIntent.setData(Uri.parse("https://teamtastico.com/community/terms/"));
                            startActivity(browserIntent);
                        }
                    });

                } else {
                    isTermsChecked = true;
                    binding.imgChecked.setImageResource(R.drawable.uncheck);
                }

            }

        } else if (view == binding.llAboutUs) {
            Intent intent = new Intent(this, AboutUs.class);
            startActivity(intent);

        }


    }

}
