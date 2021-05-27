package com.example.blooddonationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText numberEt , passwordEt;
    Button submit_button;
    TextView signupText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        numberEt = findViewById(R.id.number);
        passwordEt = findViewById(R.id.password);
        submit_button = findViewById(R.id.submitt_button);
        signupText = findViewById(R.id.signup);
        signupText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
            }
        });
      numberEt.addOnLayoutChangeListener((View.OnLayoutChangeListener) loginTextWatcher);
      passwordEt.addOnLayoutChangeListener((View.OnLayoutChangeListener) loginTextWatcher);
    }
    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
              String number = numberEt.getText().toString().trim();
              String textPassword =  passwordEt.getText().toString().trim();

              submit_button.setEnabled(!number.isEmpty() && !textPassword.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
