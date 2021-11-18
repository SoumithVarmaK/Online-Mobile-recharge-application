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

public class LoginActivity extends AppCompatActivity {

    Button backButton,loginButton;
    EditText emailEdit,passwordedit;
    ProgressBar progressBar;
    String email,password;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        backButton=(Button)findViewById(R.id.BackButton);
        loginButton=(Button)findViewById(R.id.LoginButton);
        emailEdit=(EditText)findViewById(R.id.UsernameEdit);
        passwordedit=(EditText)findViewById(R.id.PasswordEdit);
        progressBar=(ProgressBar)findViewById(R.id.Progress);

        fAuth=FirebaseAuth.getInstance();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void Login(View view){
        email=emailEdit.getText().toString().trim();
        password=passwordedit.getText().toString().trim();

        if(email.isEmpty()){
            emailEdit.setError("Required");
            return;
        }

        if(password.isEmpty()){
            passwordedit.setError("Required");
            return;}

        progressBar.setVisibility(View.VISIBLE);
        emailEdit.setEnabled(false);
        passwordedit.setEnabled(false);
        LoginWithFAuth();
    }

    private void LoginWithFAuth() {
        fAuth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(LoginActivity.this, "Signed In", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this,SelectOpeatorActivity.class));
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                emailEdit.setEnabled(true);
                progressBar.setVisibility(View.INVISIBLE);
                passwordedit.setEnabled(true);
                Toast.makeText(LoginActivity.this, "Something went Wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
