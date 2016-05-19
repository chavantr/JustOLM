package com.mywings.justolm;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.mywings.justolm.Utilities.Halted;

import java.util.Calendar;

public class Registration extends JustOlmCompactActivity {


    //region UI Controls
    private AppCompatEditText txtFirstName;
    private AppCompatEditText txtMiddleName;
    private AppCompatEditText txtLastName;
    private AppCompatEditText txtDateOfBirth;
    private AppCompatSpinner txtGender;
    private AppCompatEditText txtProfession;
    private AppCompatEditText txtAddress;
    private AppCompatSpinner txtCountry;
    private AppCompatSpinner txtState;
    private AppCompatEditText txtCity;
    private AppCompatSpinner txtArea;
    private AppCompatEditText txtPinCode;
    private AppCompatEditText txtEmail;
    private AppCompatEditText txtMobileNumber;
    private AppCompatTextView lblSecurityCode;
    private AppCompatEditText txtSecurityCode;
    private AppCompatEditText txtCreatePassword;
    private AppCompatEditText txtConformPassword;
    private Button btnCreateAccount;
    //endregion

    //region Variables
    private Halted halted;
    final Calendar c = Calendar.getInstance();
    final com.mywings.justolm.Model.Registration registration = com.mywings.justolm.Model.Registration.getInstance();
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
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRegistration();
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
        txtState = (AppCompatSpinner) findViewById(R.id.txtState);
        txtCity = (AppCompatEditText) findViewById(R.id.txtCity);
        txtArea = (AppCompatSpinner) findViewById(R.id.txtArea);
        txtCountry = (AppCompatSpinner) findViewById(R.id.txtCountry);
        txtPinCode = (AppCompatEditText) findViewById(R.id.txtPinCode);
        txtEmail = (AppCompatEditText) findViewById(R.id.txtEmail);
        txtMobileNumber = (AppCompatEditText) findViewById(R.id.txtMobileNumber);
        lblSecurityCode = (AppCompatTextView) findViewById(R.id.lblSecurityCode);
        txtSecurityCode = (AppCompatEditText) findViewById(R.id.txtSecurityCode);
        txtCreatePassword = (AppCompatEditText) findViewById(R.id.txtPassword);
        txtConformPassword = (AppCompatEditText) findViewById(R.id.txtConfirmPassword);
        btnCreateAccount = (Button) findViewById(R.id.btnCreateAccount);
        lblSecurityCode.setText(halted.getSaltString());
    }

    /**
     *
     */
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
            dateTimeUtils.update(year, month, day);
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
     *
     */
    private void updateRegistration() {
        registration.setFirstName(txtFirstName.getText().toString().trim());
        registration.setMiddleName(txtMiddleName.getText().toString().trim());
        registration.setLastName(txtLastName.getText().toString().trim());
        registration.setDateOfBirth(txtDateOfBirth.getText().toString().trim());
        registration.setGender(txtGender.getSelectedItem().toString().trim());
        registration.setProfession(txtProfession.getText().toString().trim());
        registration.setAddress(txtAddress.getText().toString().trim());
        registration.setCountry(txtCountry.getSelectedItem().toString().trim());
        registration.setState(txtState.getSelectedItem().toString().trim());
        registration.setCity(txtCity.getText().toString().trim());
        registration.setArea(txtArea.getSelectedItem().toString().trim());
        registration.setPinCode(txtPinCode.getText().toString().trim());
        registration.setEmail(txtEmail.getText().toString().trim());
        registration.setMobileNumber(txtMobileNumber.getText().toString().trim());
        registration.setSecurityCode(txtSecurityCode.getText().toString().trim());
        registration.setPassword(txtCreatePassword.getText().toString().trim());
        Toast.makeText(Registration.this,registration.getFirstName(),Toast.LENGTH_LONG).show();
    }
}
