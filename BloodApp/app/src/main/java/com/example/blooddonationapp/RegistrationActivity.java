package com.example.blooddonationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RegistrationActivity extends AppCompatActivity {
    private EditText nameEt, cityEt, bloodGroupEt, passwordEt, mobileEt;
    private Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        nameEt = findViewById(R.id.name);
        cityEt = findViewById(R.id.city);
        bloodGroupEt = findViewById(R.id.blood_group);
        passwordEt = findViewById(R.id.password);
        mobileEt = findViewById(R.id.number);
        submitButton = findViewById(R.id.submitt_button);
        submitButton.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void  onClick(View view) {
                String name, city, blood_group, password, mobile;
                name = nameEt.getText().toString();
                city = cityEt.getText().toString();
                blood_group = bloodGroupEt.getText().toString() ;
                password = passwordEt.getText().toString();
                mobile = mobileEt.getText().toString();
                if(isValid(name , city , password , mobile , blood_group)){

                }
                showMessage(name+"\n");
                Toast.makeText(RegistrationActivity.this, name + " ", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private boolean isValid (String name ,String city , String blood_group , String password , String mobile){
        List<String> valid_blood_groups = new ArrayList<>();
        valid_blood_groups.add("A+");
        valid_blood_groups.add("B+");
        valid_blood_groups.add("AB+");
        valid_blood_groups.add("A-");
        valid_blood_groups.add("B-");
        valid_blood_groups.add("AB-");
        valid_blood_groups.add("O-");
        valid_blood_groups.add("O+");


        if (name.isEmpty()) {
            String msg = "";
            showMessage("Name is Empty");
            return false;
        }else if (city.isEmpty()){
            String msg = "";
            showMessage("City name is Required");
            return false;
        }else if (!valid_blood_groups.contains(blood_group)){
            String msg = "";
            showMessage("Blood Group is InValid");
            return false;
        }else if(password.isEmpty()){
            String msg = "";
            showMessage("Password is Empty");
            return false;
        }else if(mobile.isEmpty() || mobile.length() != 10){
            String msg = "";
            showMessage("Mobile No is InValid , Mobile No should bh of 10 digits");
            return false;
        }
        return true;
    }


    private  void  showMessage(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}