package com.example.mobilerechargeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class DebitCreditActivity extends AppCompatActivity {

    Button proceedToPayButton;
    ProgressBar progressBar;
    int count=0,c=0;
    EditText cardNumEdit,cardNameEdit,expDateEdit,cvvEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debit_credit);

        proceedToPayButton=(Button) findViewById(R.id.proceedToPayButton);
        progressBar=(ProgressBar) findViewById(R.id.Progress);
        cardNameEdit=(EditText) findViewById(R.id.cardNameEdit);
        cardNumEdit=(EditText) findViewById(R.id.cardNumEdit);
        expDateEdit=(EditText) findViewById(R.id.expDateEdit);
        cvvEdit=(EditText) findViewById(R.id.cvvEdit);

        cardNumEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().startsWith("2")||s.toString().startsWith("5"))
                    cardNumEdit.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.ic_mastercard_logo),null,null,null);
                else if(s.toString().startsWith("4"))
                    cardNumEdit.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.ic_visa_logo),null,null,null);
                else if(s.toString().isEmpty())
                    cardNumEdit.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null);
                else
                    cardNumEdit.setError("MasterCard or Visa Only");


                int inputlength = cardNumEdit.getText().toString().length();

                if(inputlength!=19){
                    cardNumEdit.setError("Invalid");
                }

                if (count <= inputlength && inputlength == 4 || inputlength == 9 || inputlength == 14){

                    cardNumEdit.setText(cardNumEdit.getText().toString() + " ");

                    int pos = cardNumEdit.getText().length();
                    cardNumEdit.setSelection(pos);

                } else if (count >= inputlength && (inputlength == 4 || inputlength == 9 || inputlength == 14)) {
                    cardNumEdit.setText(cardNumEdit.getText().toString()
                            .substring(0, cardNumEdit.getText()
                                    .toString().length() - 1));

                    int pos = cardNumEdit.getText().length();
                    cardNumEdit.setSelection(pos);
                }
                count = cardNumEdit.getText().toString().length();
            }
        });

        expDateEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int inputlength = expDateEdit.getText().toString().length();

                if(inputlength>14){
                    expDateEdit.setError("Invalid");
                }

                if (c <= inputlength && inputlength == 2){

                    expDateEdit.setText(expDateEdit.getText().toString() + "/");

                    int pos = expDateEdit.getText().length();
                    expDateEdit.setSelection(pos);

                }
                c = expDateEdit.getText().toString().length();
            }

        });

        proceedToPayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cardNameEdit.getText().toString().isEmpty()||cardNumEdit.getText().toString().isEmpty()||expDateEdit.getText().toString().isEmpty()||cvvEdit.getText().toString().isEmpty())
                    Toast.makeText(DebitCreditActivity.this, "Enter all Fields", Toast.LENGTH_SHORT).show();
                else if(cardNumEdit.getError()!=null)
                    Toast.makeText(DebitCreditActivity.this, "Invalid Inputs", Toast.LENGTH_SHORT).show();
                else{
                    progressBar.setVisibility(View.VISIBLE);
                    (new Handler()).postDelayed(this::nextActivity,1000);
                }
            }

            private void nextActivity() {
                startActivity(new Intent(DebitCreditActivity.this,TransactionSuccessActivity.class));
                finish();
            }
        });
    }

    public void clearCardNum(View view){
        cardNumEdit.setText("");
    }

    public void backButton(View view){
        finish();
    }
}
