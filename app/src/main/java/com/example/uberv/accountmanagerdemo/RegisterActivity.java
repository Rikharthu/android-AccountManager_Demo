package com.example.uberv.accountmanagerdemo;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    public static final String EXTRA_EMAIL = "extra_email";
    public static final String EXTRA_PWD = "extra_pwd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void onRegister(View view) {
        String email = ((EditText) findViewById(R.id.email_et)).getText().toString();
        String pwd = ((EditText) findViewById(R.id.pwd_et)).getText().toString();

        if (email != null && email.length() >= 6 && email.contains("@")
                && pwd != null && pwd.length() >= 6) {

            Intent intent = new Intent();
            intent.putExtra(EXTRA_EMAIL, email);
            intent.putExtra(EXTRA_PWD, pwd);
            setResult(RESULT_OK,intent);
            finish();
        }
    }
}
