package com.example.mobilerechargeapp.ProviderPages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mobilerechargeapp.R;
import com.example.mobilerechargeapp.SelectPaymentMethodActivity;

public class JioProviderActivity extends AppCompatActivity {

    Button button2399,button599,button2121,button555,button149;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jio_provider);

        button2399=(Button)findViewById(R.id.button1);
        button599=(Button)findViewById(R.id.button2);
        button2121=(Button)findViewById(R.id.button3);
        button555=(Button)findViewById(R.id.button4);
        button149=(Button)findViewById(R.id.button5);

        button2399.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(JioProviderActivity.this, SelectPaymentMethodActivity.class);
                intent.putExtra("amount","2399");
                startActivity(intent);
            }
        });

        button599.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(JioProviderActivity.this, SelectPaymentMethodActivity.class);
                intent.putExtra("amount","599");
                startActivity(intent);
            }
        });

        button2121.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(JioProviderActivity.this, SelectPaymentMethodActivity.class);
                intent.putExtra("amount","2121");
                startActivity(intent);
            }
        });

        button555.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(JioProviderActivity.this, SelectPaymentMethodActivity.class);
                intent.putExtra("amount","555");
                startActivity(intent);
            }
        });

        button149.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(JioProviderActivity.this, SelectPaymentMethodActivity.class);
                intent.putExtra("amount","149");
                startActivity(intent);
            }
        });
    }

    public void backButton(View view){
        finish();
    }
}
