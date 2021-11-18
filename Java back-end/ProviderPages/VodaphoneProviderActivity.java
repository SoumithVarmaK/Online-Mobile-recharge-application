package com.example.mobilerechargeapp.ProviderPages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mobilerechargeapp.R;
import com.example.mobilerechargeapp.SelectPaymentMethodActivity;

public class VodaphoneProviderActivity extends AppCompatActivity {

    Button button2399,button249,button599,button299,button399;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vodaphone_provider);

        button2399=(Button)findViewById(R.id.button1);
        button249=(Button)findViewById(R.id.button2);
        button599=(Button)findViewById(R.id.button3);
        button299=(Button)findViewById(R.id.button4);
        button399=(Button)findViewById(R.id.button5);

        button2399.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(VodaphoneProviderActivity.this, SelectPaymentMethodActivity.class);
                intent.putExtra("amount","2399");
                startActivity(intent);
            }
        });

        button249.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(VodaphoneProviderActivity.this, SelectPaymentMethodActivity.class);
                intent.putExtra("amount","249");
                startActivity(intent);
            }
        });

        button599.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(VodaphoneProviderActivity.this, SelectPaymentMethodActivity.class);
                intent.putExtra("amount","599");
                startActivity(intent);
            }
        });

        button299.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(VodaphoneProviderActivity.this, SelectPaymentMethodActivity.class);
                intent.putExtra("amount","299");
                startActivity(intent);
            }
        });

        button399.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(VodaphoneProviderActivity.this, SelectPaymentMethodActivity.class);
                intent.putExtra("amount","399");
                startActivity(intent);
            }
        });
    }

    public void backButton(View view){
        finish();
    }
}
