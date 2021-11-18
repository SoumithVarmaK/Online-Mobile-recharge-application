package com.example.mobilerechargeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class NetBankingActivity extends AppCompatActivity {

    EditText usernameEdit,passwordEdit;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_banking);

        usernameEdit=(EditText)findViewById(R.id.UsernameEdit);
        passwordEdit=(EditText)findViewById(R.id.PasswordEdit);
        progressBar=(ProgressBar)findViewById(R.id.Progress);
    }

    public void proceedToPay(View view){
        if(usernameEdit.getText().toString().isEmpty()||passwordEdit.getText().toString().isEmpty())
            Toast.makeText(this, "Enter all Fields", Toast.LENGTH_SHORT).show();
        else{
            progressBar.setVisibility(View.VISIBLE);
            (new Handler()).postDelayed(this::nextActivity,1000);
        }

    }

    private void nextActivity() {
        startActivity(new Intent(NetBankingActivity.this,TransactionSuccessActivity.class));
        finish();
    }

    public void backButton(View view){
        finish();
    }
}
