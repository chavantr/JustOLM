package com.mywings.justolm;

import android.os.Bundle;
import android.view.View;
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
        initialization();
        events();
    }


    /**
     * Initialization
     */
    private void initialization() {
        getSupportActionBar().hide();
        btnLogin = (Button) findViewById(R.id.btnSignIn);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        lblAdminLogin = (TextView) findViewById(R.id.lblAdminLogin);
        lblForgotPassword = (TextView) findViewById(R.id.lblForgotPassword);
    }

    private void events() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}

