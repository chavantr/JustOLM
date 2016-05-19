package com.mywings.justolm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
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
     * @return
     */
    public ViewGroup getGroup() {
        final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this
                .findViewById(android.R.id.content)).getChildAt(0);
        return viewGroup;
    }
}
