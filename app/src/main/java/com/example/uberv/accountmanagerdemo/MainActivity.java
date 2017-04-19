package com.example.uberv.accountmanagerdemo;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    public static final String ACCOUNT_TYPE = "com.example.uberv.accountmanagerdemo";
    private static final int REQUEST_CODE_REGISTER = 1;

    private AccountManager mAccountManager;

    private ListView mAccountsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAccountsList = (ListView) findViewById(R.id.accounts_list);

        mAccountManager = AccountManager.get(this);

        showAllAccounts();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_REGISTER) {
            if (resultCode == RESULT_OK) {
                String email = data.getStringExtra(RegisterActivity.EXTRA_EMAIL);
                String pwd = data.getStringExtra(RegisterActivity.EXTRA_PWD);

                final Account account = new Account(email, ACCOUNT_TYPE);
                mAccountManager.addAccountExplicitly(account, pwd, null);

                showAllAccounts();
            }
        }
    }

    private void showAllAccounts() {
        Account[] accounts = mAccountManager.getAccounts();
        List<String> accountNames = new ArrayList<>();
        for (Account account : accounts) {
            accountNames.add(account.name + "\n" + account.type);
        }

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, android.R.id.text1, accountNames);

        mAccountsList.setAdapter(itemsAdapter);
    }

    public void onRegister(View view) {
        startActivityForResult(new Intent(this, RegisterActivity.class), REQUEST_CODE_REGISTER);
    }
}
