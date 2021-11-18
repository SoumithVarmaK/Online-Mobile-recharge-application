package com.example.mobilerechargeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SlapshScreen extends AppCompatActivity {

    Animation coin_anim,coin_after_anim,mobile_up;
    ImageView mobile,coin,cover;
    TextView easyName,chargeName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slapsh_screen);

        mobile=(ImageView)findViewById(R.id.mobileImg);
        cover=(ImageView)findViewById(R.id.ic_spark_cover);
        coin=(ImageView)findViewById(R.id.coinImg);
        easyName=(TextView) findViewById(R.id.EasyName);
        chargeName=(TextView) findViewById(R.id.ChargeName);

        coin_anim= AnimationUtils.loadAnimation(this,R.anim.coin_anim);
        coin_after_anim= AnimationUtils.loadAnimation(this,R.anim.coin_after_anim);
        mobile_up= AnimationUtils.loadAnimation(this,R.anim.mobile_move_anim);

        mobile.setAnimation(mobile_up);


        (new Handler()).postDelayed(this::coinIn,500);
    }

    private void coinIn() {
        coin.setVisibility(View.VISIBLE);
        coin.setAnimation(coin_anim);
        (new Handler()).postDelayed(this::coinAfter,1000);
    }

    private void coinAfter() {
        coin.setAnimation(coin_after_anim);
        (new Handler()).postDelayed(this::coinGone,200);
    }

    private void coinGone() {
        coin.setVisibility(View.INVISIBLE);
        (new Handler()).postDelayed(this::mobilescale,500);
    }

    private void mobilescale() {
        mobile.animate().translationY(100).alpha(0).setDuration(500);
        (new Handler()).postDelayed(this::mobileGone,500);
    }

    private void mobileGone() {
        mobile.animate().alpha(0).setDuration(200);
        (new Handler()).postDelayed(this::mobileInv,200);
    }

    private void mobileInv() {
        easyName.animate().translationX(50).alpha(1).setDuration(800);
        chargeName.animate().translationX(-50).alpha(1).setDuration(800);
        (new Handler()).postDelayed(this::moveCover,200);
    }

    private void moveCover() {
        cover.animate().translationYBy(200).setDuration(1000);
        (new Handler()).postDelayed(this::startApp,1500);
    }

    private void startApp() {
        startActivity(new Intent(SlapshScreen.this,MainActivity.class));
    }
}
