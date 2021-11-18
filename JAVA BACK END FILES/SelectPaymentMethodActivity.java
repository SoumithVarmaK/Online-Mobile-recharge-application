package com.example.mobilerechargeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class SelectPaymentMethodActivity extends AppCompatActivity {

    String Amount;
    TextView amountPayableText;
    EditText mobileEdit;
    RadioButton debitRadio,creditRadio,netRadio;
    Button proceedToPayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_payment_method);

        Bundle bundle=getIntent().getExtras();

        amountPayableText=(TextView)findViewById(R.id.amountPayableText);
        mobileEdit=(EditText)findViewById(R.id.MobileNumEdit);
        debitRadio=(RadioButton)findViewById(R.id.debitCardRadio);
        creditRadio=(RadioButton)findViewById(R.id.creditCardRadio);
        netRadio=(RadioButton)findViewById(R.id.netBankingRadio);
        proceedToPayButton=(Button) findViewById(R.id.proceedToPayButton);

        Amount=bundle.getString("amount");
        amountPayableText.setText(Amount+"/-");

        proceedToPayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mobileEdit.getText().toString().isEmpty())
                    mobileEdit.setError("Required");
                else if(mobileEdit.getText().toString().length()<10||mobileEdit.getText().toString().length()>10)
                    mobileEdit.setError("Invalid");
                else{
                    if(debitRadio.isChecked()||creditRadio.isChecked()){
                        startActivity(new Intent(SelectPaymentMethodActivity.this,DebitCreditActivity.class));
                    }
                    else if(netRadio.isChecked())
                        startActivity(new Intent(SelectPaymentMethodActivity.this,NetBankingActivity.class));
                    else
                        Toast.makeText(SelectPaymentMethodActivity.this, "Select a Payment Method", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void phonePeImage(View view){
        if(mobileEdit.getText().toString().isEmpty()){
            mobileEdit.setError("Required");
        }
        else {
            Intent intent=new Intent(SelectPaymentMethodActivity.this,BhimUpiActivity.class);
            intent.putExtra("amount",Amount);
            startActivity(intent);
        }
    }

    public void googlePayImage(View view){
        if(mobileEdit.getText().toString().isEmpty()){
            mobileEdit.setError("Required");
        }
        else {
            Intent intent=new Intent(SelectPaymentMethodActivity.this,BhimUpiActivity.class);
            intent.putExtra("amount",Amount);
            startActivity(intent);
        }
    }

    public void paytmImage(View view){
        if(mobileEdit.getText().toString().isEmpty()){
            mobileEdit.setError("Required");
        }
        else {
            Intent intent=new Intent(SelectPaymentMethodActivity.this,BhimUpiActivity.class);
            intent.putExtra("amount",Amount);
            startActivity(intent);
        }
    }

    public void backButton(View view){
        finish();
    }
}
