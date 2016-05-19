package com.mywings.justolm;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;

import com.mywings.justolm.Utilities.Halted;

import java.util.Calendar;

public class Registration extends AppCompatActivity {


    //region UI Controls
    private AppCompatEditText txtFirstName;
    private AppCompatEditText txtMiddleName;
    private AppCompatEditText txtLastName;
    private AppCompatEditText txtDateOfBirth;
    private AppCompatSpinner txtGender;
    private AppCompatEditText txtProfession;
    private AppCompatEditText txtAddress;
    private AppCompatSpinner txtCountry;
    private AppCompatEditText txtPinCode;
    private AppCompatEditText txtEmail;
    private AppCompatEditText txtMobileNumber;
    private AppCompatTextView lblSecurityCode;
    private AppCompatEditText txtSecurityCode;
    private AppCompatEditText txtCreatePassword;
    private AppCompatEditText txtConformPassword;
    //endregion

    //region Variables
    private Halted halted;
    final Calendar c = Calendar.getInstance();
    //endregion


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        init();
        initializaUIComponents();

        events();
    }

    private void events() {
        txtDateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
    }

    private void initializaUIComponents() {
        txtFirstName = (AppCompatEditText) findViewById(R.id.txtFirstName);
        txtMiddleName = (AppCompatEditText) findViewById(R.id.txtMiddleName);
        txtLastName = (AppCompatEditText) findViewById(R.id.txtLastName);
        txtDateOfBirth = (AppCompatEditText) findViewById(R.id.txtDateOfBirth);
        txtGender = (AppCompatSpinner) findViewById(R.id.txtGender);
        txtProfession = (AppCompatEditText) findViewById(R.id.txtProfession);
        txtAddress = (AppCompatEditText) findViewById(R.id.txtAddress);
        txtCountry = (AppCompatSpinner) findViewById(R.id.txtCountry);
        txtPinCode = (AppCompatEditText) findViewById(R.id.txtPinCode);
        txtEmail = (AppCompatEditText) findViewById(R.id.txtEmail);
        txtMobileNumber = (AppCompatEditText) findViewById(R.id.txtMobileNumber);
        lblSecurityCode = (AppCompatTextView) findViewById(R.id.lblSecurityCode);
        txtSecurityCode = (AppCompatEditText) findViewById(R.id.txtSecurityCode);
        txtCreatePassword = (AppCompatEditText) findViewById(R.id.txtPassword);
        txtConformPassword = (AppCompatEditText) findViewById(R.id.txtConfirmPassword);
        lblSecurityCode.setText(halted.getSaltString());
    }

    private void init() {
        halted = new Halted();
    }

    public class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            update(year, month, day);
        }

    }

    /**
     *
     */
    private void showDatePickerDialog() {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }


    /**
     * @param year
     * @param month
     * @param day
     */
    private void update(int year, int month, int day) {
        String strday;
        String strmonth;

        if ((month + 1) <= 9) {
            strmonth = "0" + String.valueOf(month + 1);
        } else {
            strmonth = String.valueOf(month + 1);
        }

        if (day <= 9) {
            strday = "0" + String.valueOf(day);
        } else {
            strday = String.valueOf(day);
        }
        txtDateOfBirth.setText(strmonth + "/" + strday + "/" + year);
    }
}
