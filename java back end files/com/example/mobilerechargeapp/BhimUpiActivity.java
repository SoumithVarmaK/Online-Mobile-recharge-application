package com.example.mobilerechargeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class BhimUpiActivity extends AppCompatActivity {

    String Amount;
    TextView amountPayableText;
    Button proceedToPayButton;
    ProgressBar progressBar;
    EditText idEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bhim_upi);

        amountPayableText=(TextView)findViewById(R.id.amountPayableText);
        proceedToPayButton=(Button) findViewById(R.id.proceedToPayButton);
        progressBar=(ProgressBar)findViewById(R.id.Progress);
        idEdit=(EditText)findViewById(R.id.idEdit);

        Bundle bundle=getIntent().getExtras();

        Amount=bundle.getString("amount");
        amountPayableText.setText(Amount+"/-");

        proceedToPayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(idEdit.getText().toString().isEmpty())
                    Toast.makeText(BhimUpiActivity.this, "Enter ID", Toast.LENGTH_SHORT).show();
                else{
                    progressBar.setVisibility(View.VISIBLE);
                    (new Handler()).postDelayed(this::nextActivity,1000);
                }
            }

            private void nextActivity() {
                startActivity(new Intent(BhimUpiActivity.this,TransactionSuccessActivity.class));
                finish();
            }
        });
    }

    public void backButton(View view){
        finish();
    }
}
