package com.sreenadth.form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private EditText nameEdt,emailEdt,mobileEdt,passwordEdt,rePasswordEdt;
    private Button registerBtn;
    private TextView loginTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }
    private void init(){
        nameEdt = findViewById(R.id.fullname_edt);
        emailEdt = findViewById(R.id.email_edt);
        mobileEdt = findViewById(R.id.mobile_edt);
        passwordEdt = findViewById(R.id.password_edt);
        rePasswordEdt = findViewById(R.id.confirm_password_edt);
        registerBtn = findViewById(R.id.register_btn);
        loginTv = findViewById(R.id.login_here);


        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkValidations()){
                    Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });
        loginTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
    private boolean checkValidations(){
        if (nameEdt.getText().toString().length()<1){
            nameEdt.setError("Enter Name");
            return false;
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailEdt.getText().toString()).matches()){
            emailEdt.setError("Enter valid email");
            return false;
        }
        if (mobileEdt.getText().length()<10){
            mobileEdt.setError("Enter valid mobile number");
            return false;
        }
        if (passwordEdt.getText().toString().isEmpty()){
            passwordEdt.setError("Enter password");
            return false;
        }
        if (!passwordEdt.getText().toString().equals(rePasswordEdt.getText().toString())){
            rePasswordEdt.setError("Password did not match");
            return false;
        }
        return true;
    }
}
