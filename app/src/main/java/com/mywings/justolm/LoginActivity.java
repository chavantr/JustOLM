package com.mywings.justolm;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;


public class LoginActivity extends JustOlmCompactActivity {

    private Button btnLogin;
    private Button btnRegister;
    private TextView lblAdminLogin;
    private TextView lblForgotPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

    }
}

