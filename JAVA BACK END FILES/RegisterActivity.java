package com.example.mobilerechargeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    FirebaseAuth fAuth;
    EditText emailEdit,mobileEdit,passEdit,confPassEdit;
    Button registerButton,backButton;
    ProgressBar progressBar;
    String email,password,confPassword,mobileNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fAuth = FirebaseAuth.getInstance();

        backButton=(Button)findViewById(R.id.BackButton);
        emailEdit=(EditText)findViewById(R.id.UsernameEdit);
        mobileEdit=(EditText)findViewById(R.id.MobileEdit);
        passEdit=(EditText)findViewById(R.id.PasswordEdit);
        confPassEdit=(EditText)findViewById(R.id.ConfirmPasswordEdit);
        registerButton=(Button)findViewById(R.id.RegisterButton);
        progressBar=(ProgressBar)findViewById(R.id.Progress);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void Register(View view){

        email=emailEdit.getText().toString().trim();
        mobileNum=mobileEdit.getText().toString().trim();
        password=passEdit.getText().toString().trim();
        confPassword=confPassEdit.getText().toString().trim();

        if(email.isEmpty()){
            emailEdit.setError("Required");
            return;
        }

        if(mobileNum.isEmpty()){
            mobileEdit.setError("Required");
            return;}

        if(password.isEmpty()){
            passEdit.setError("Required");
            return;}

        if(confPassword.isEmpty()){
            confPassEdit.setError("Required");
            return;}

        if(password.length()<6){
            passEdit.setError("Minimum 6 Characters");
            return;}

        if(!(password.matches(confPassword))){
            Toast.makeText(this, "Password dont match", Toast.LENGTH_SHORT).show();
            return;}

        progressBar.setVisibility(View.VISIBLE);
        emailEdit.setEnabled(false);
        passEdit.setEnabled(false);
        mobileEdit.setEnabled(false);
        confPassEdit.setEnabled(false);

        RegisterWithFAuth();

    }

    private void RegisterWithFAuth() {
        fAuth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(RegisterActivity.this, "Account Created !", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterActivity.this,SelectOpeatorActivity.class));
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressBar.setVisibility(View.VISIBLE);
                emailEdit.setEnabled(true);
                passEdit.setEnabled(true);
                mobileEdit.setEnabled(true);
                confPassEdit.setEnabled(true);
                Toast.makeText(RegisterActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
