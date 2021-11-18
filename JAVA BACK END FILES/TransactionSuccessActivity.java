package com.example.mobilerechargeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class TransactionSuccessActivity extends AppCompatActivity {

    ImageView CheckImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_success);

        CheckImage=(ImageView)findViewById(R.id.checkImage);

        Animation animation= AnimationUtils.loadAnimation(this,R.anim.transaction_success_anim);

        CheckImage.setAnimation(animation);

        (new Handler()).postDelayed(this::GoHome,2000);
    }

    private void GoHome() {
        startActivity(new Intent(TransactionSuccessActivity.this,SelectOpeatorActivity.class));
    }
}
