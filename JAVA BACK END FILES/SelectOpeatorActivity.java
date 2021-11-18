package com.example.mobilerechargeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mobilerechargeapp.ProviderPages.AirtelProviderActivity;
import com.example.mobilerechargeapp.ProviderPages.JioProviderActivity;
import com.example.mobilerechargeapp.ProviderPages.VodaphoneProviderActivity;
import com.example.mobilerechargeapp.ProviderPages.bsnlProviderActivity;
import com.google.firebase.auth.FirebaseAuth;

public class SelectOpeatorActivity extends AppCompatActivity {

    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_opeator);

        backButton=(Button)findViewById(R.id.BackButton);

    }

    public void logout(View view) {
        try{
            if (FirebaseAuth.getInstance().getCurrentUser() != null) {
                signout();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void signout() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(SelectOpeatorActivity.this, MainActivity.class));
        finish();
    }

    public void jioOperator(View view){
        startActivity(new Intent(SelectOpeatorActivity.this, JioProviderActivity.class));

    }

    public void airtelOperator(View view){
        startActivity(new Intent(SelectOpeatorActivity.this, AirtelProviderActivity.class));

    }

    public void viOperator(View view){
        startActivity(new Intent(SelectOpeatorActivity.this, VodaphoneProviderActivity.class));

    }

    public void bsnlOperator(View view){
        startActivity(new Intent(SelectOpeatorActivity.this, bsnlProviderActivity.class));

    }
}
