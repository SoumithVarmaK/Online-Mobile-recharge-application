package com.example.mobilerechargeapp.ProviderPages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mobilerechargeapp.R;
import com.example.mobilerechargeapp.SelectPaymentMethodActivity;

public class bsnlProviderActivity extends AppCompatActivity {

    Button button365,button186,button500,button153,button297;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bsnl_provider);

        button365=(Button)findViewById(R.id.button1);
        button186=(Button)findViewById(R.id.button2);
        button500=(Button)findViewById(R.id.button3);
        button153=(Button)findViewById(R.id.button4);
        button297=(Button)findViewById(R.id.button5);

        button365.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(bsnlProviderActivity.this, SelectPaymentMethodActivity.class);
                intent.putExtra("amount","365");
                startActivity(intent);
            }
        });

        button186.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(bsnlProviderActivity.this, SelectPaymentMethodActivity.class);
                intent.putExtra("amount","186");
                startActivity(intent);
            }
        });

        button500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(bsnlProviderActivity.this, SelectPaymentMethodActivity.class);
                intent.putExtra("amount","500");
                startActivity(intent);
            }
        });

        button153.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(bsnlProviderActivity.this, SelectPaymentMethodActivity.class);
                intent.putExtra("amount","153");
                startActivity(intent);
            }
        });

        button297.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(bsnlProviderActivity.this, SelectPaymentMethodActivity.class);
                intent.putExtra("amount","297");
                startActivity(intent);
            }
        });
    }

    public void backButton(View view){
        finish();
    }
}
