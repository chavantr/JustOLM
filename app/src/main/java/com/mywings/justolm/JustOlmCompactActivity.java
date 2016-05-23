package com.mywings.justolm;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.mywings.justolm.UserInteraction.OnNotificationListener;
import com.mywings.justolm.Utilities.DateTimeUtils;
import com.mywings.justolm.Utilities.NetworkUtil;
import com.mywings.justolm.Utilities.ValidationHelper;

/**
 * Created by Tatyabhau Chavan on 5/17/2016.
 */
public abstract class JustOlmCompactActivity extends AppCompatActivity implements OnNotificationListener {


    private NetworkUtil networkUtil;
    public ValidationHelper validationHelper;
    public DateTimeUtils dateTimeUtils;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        networkUtil = new NetworkUtil(getApplicationContext());
        validationHelper = new ValidationHelper();
        dateTimeUtils = DateTimeUtils.getInstance();

    }

    @Override
    public void show(String message) {

    }

    @Override
    public void show(String message, View id) {

        Snackbar.make(id, message, Snackbar.LENGTH_LONG)
                .setAction(R.string.action_ok, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                }).show();

    }

    @Override
    public boolean isConnected() {
        if (!networkUtil.isConnected()) {
            show(getString(R.string.internect_connectivity), getGroup());
        }
        return networkUtil.isConnected();
    }

    /**
     *
     */
    public Dialog logout() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(getString(R.string.app_name));
        builder.setMessage(getString(R.string.acton_logout));
        builder.setPositiveButton(getString(R.string.action_yes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                logoutScreen();
            }
        });
        builder.setNegativeButton(getString(R.string.action_no), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setCancelable(false);
        return builder.create();
    }

    /**
     * @return
     */
    public ViewGroup getGroup() {
        final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this
                .findViewById(android.R.id.content)).getChildAt(0);
        return viewGroup;
    }

    private void logoutScreen() {
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }
}
