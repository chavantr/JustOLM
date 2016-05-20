package com.mywings.justolm;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;


public class LoginActivity extends JustOlmCompactActivity {


    //region
    private Button btnLogin;
    private Button btnRegister;
    private TextView lblAdminLogin;
    private TextView lblForgotPassword;
    private AppCompatEditText txtUserName;
    private AppCompatEditText txtPassword;
    private Dialog dialog;
    //endregion

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
        txtUserName = (AppCompatEditText) findViewById(R.id.userName);
        txtPassword = (AppCompatEditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.btnSignIn);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        lblAdminLogin = (TextView) findViewById(R.id.lblAdminLogin);
        lblForgotPassword = (TextView) findViewById(R.id.lblForgotPassword);

    }

    /**
     *
     */
    private void events() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isConnected())
                    isValidateLogin(v);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRegistration();
            }
        });

        lblAdminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = showAdmin();
                dialog.show();
            }
        });
    }

    private void isValidateLogin(View view) {
        if (!txtUserName.getText().toString().isEmpty() && !txtPassword.getText().toString().isEmpty() && validationHelper.validate(txtUserName.getText().toString().trim())) {

        } else if (txtUserName.getText().toString().isEmpty() && txtPassword.getText().toString().isEmpty()) {
            show(getString(R.string.enter_username_password), view);
        } else if (!validationHelper.validate(txtUserName.getText().toString().trim())) {
            show(getString(R.string.enter_valid_email), view);
        } else if (txtUserName.getText().toString().isEmpty()) {
            show("Please enter email.", view);
        } else if (txtPassword.getText().toString().isEmpty()) {
            show("Please enter valid password.", view);
        }
    }

    /**
     *
     */
    private void startRegistration() {
        Intent intent = new Intent(LoginActivity.this, Registration.class);
        startActivity(intent);
    }

    /**
     *
     */
    private Dialog showAdmin() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View popup = inflater.inflate(R.layout.popup_admin, null);
        Button btnLogin = (Button) popup.findViewById(R.id.btnLogin);
        Button btnCancel = (Button) popup.findViewById(R.id.btnCancel);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        builder.setView(popup);
        builder.setCancelable(false);
        return builder.create();
    }
}

