package com.mywings.justolm;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MyProfile extends JustOlmCompactActivity
        implements NavigationView.OnNavigationItemSelectedListener {


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
    private AppCompatSpinner txtCity;
    private AppCompatSpinner txtArea;
    private AppCompatEditText txtPinCode;
    private AppCompatEditText txtEmail;
    private AppCompatEditText txtMobileNumber;
    private Button btnUpdateProfile;
    private Button btnEdit;
    private DrawerLayout drawer;
    private Dialog dialog;
    //endregion


    //region Variables
    final Calendar c = Calendar.getInstance();
    final com.mywings.justolm.Model.Registration registration = com.mywings.justolm.Model.Registration.getInstance();
    private List<AppCompatEditText> inputList;
    private List<AppCompatSpinner> selectList;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);
        initialization();
        events();
        disableInput();
    }

    private void events() {
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btnEdit.getText().toString().trim().equalsIgnoreCase("Edit")) {
                    btnEdit.setText(R.string.cancel);
                    btnUpdateProfile.setVisibility(View.VISIBLE);
                    enableInput();
                } else {
                    btnEdit.setText(R.string.edit);
                    btnUpdateProfile.setVisibility(View.GONE);
                    disableInput();
                }
            }
        });

        txtDateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        btnUpdateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRegistration();
            }
        });
    }

    private void initialization() {
        txtFirstName = (AppCompatEditText) findViewById(R.id.txtFirstName);
        txtMiddleName = (AppCompatEditText) findViewById(R.id.txtMiddleName);
        txtLastName = (AppCompatEditText) findViewById(R.id.txtLastName);
        txtDateOfBirth = (AppCompatEditText) findViewById(R.id.txtDateOfBirth);
        txtGender = (AppCompatSpinner) findViewById(R.id.txtGender);
        txtProfession = (AppCompatEditText) findViewById(R.id.txtProfession);
        txtAddress = (AppCompatEditText) findViewById(R.id.txtAddress);
        txtState = (AppCompatSpinner) findViewById(R.id.txtState);
        txtCity = (AppCompatSpinner) findViewById(R.id.txtCity);
        txtArea = (AppCompatSpinner) findViewById(R.id.txtArea);
        txtCountry = (AppCompatSpinner) findViewById(R.id.txtCountry);
        txtPinCode = (AppCompatEditText) findViewById(R.id.txtPinCode);
        txtEmail = (AppCompatEditText) findViewById(R.id.txtEmail);
        txtMobileNumber = (AppCompatEditText) findViewById(R.id.txtMobileNumber);

        btnUpdateProfile = (Button) findViewById(R.id.btnUpdateProfile);
        btnEdit = (Button) findViewById(R.id.btnEdit);

        initInput();

    }

    private void initInput() {
        inputList = new ArrayList<AppCompatEditText>();
        selectList = new ArrayList<AppCompatSpinner>();
        inputList.add(txtFirstName);
        inputList.add(txtMiddleName);
        inputList.add(txtLastName);
        inputList.add(txtDateOfBirth);
        inputList.add(txtProfession);
        inputList.add(txtAddress);
        inputList.add(txtPinCode);
        inputList.add(txtEmail);
        inputList.add(txtMobileNumber);

        selectList.add(txtGender);
        selectList.add(txtCity);
        selectList.add(txtState);
        selectList.add(txtArea);
        selectList.add(txtCountry);
    }

    private void enableInput() {
        for (AppCompatEditText control : inputList) {
            if (control.getId() != R.id.txtDateOfBirth) {
                control.setFocusable(true);
                control.setFocusableInTouchMode(true);
            }
            control.setClickable(true);
            control.setEnabled(true);
        }
        for (AppCompatSpinner control : selectList) {
            control.setEnabled(true);
            control.setClickable(true);
        }
    }


    private void disableInput() {
        for (AppCompatEditText control : inputList) {
            control.setFocusable(false);
            control.setFocusableInTouchMode(false);
            control.setClickable(false);
            control.setEnabled(false);
        }
        for (AppCompatSpinner control : selectList) {
            control.setEnabled(false);
            control.setClickable(false);
        }
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
        registration.setCity(txtCity.getSelectedItem().toString().trim());
        registration.setArea(txtArea.getSelectedItem().toString().trim());
        registration.setPinCode(txtPinCode.getText().toString().trim());
        registration.setEmail(txtEmail.getText().toString().trim());
        registration.setMobileNumber(txtMobileNumber.getText().toString().trim());

        validateRegistrationInfo();
    }


    private void validateRegistrationInfo() {
        if (null != registration) {
            if (registration.isEmptyFieldUpdate()) {
                show(getString(R.string.action_all_fields_mandetory), btnUpdateProfile);
            } else if (registration.isNotEmptyFieldUpdate()) {
                if (isConnected()) {

                }
            } else if (registration.getMobileNumber().length() < 10) {
                show(getString(R.string.enter_valid_ten_digit_number), btnUpdateProfile);
            }
        }
    }

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home:
                startHomeScreen();
                finish();
                break;
            case R.id.abountus:
                startAboutUs();
                finish();
                break;
            case R.id.contactus:
                contactus();
                finish();
                break;

            case R.id.neworder:
                neworder();
                break;

            case R.id.amendorder:
                startamendorder();
                finish();
                break;

            case R.id.amendschedulerorder:
                startamendscheduler();
                finish();
                break;

            case R.id.pendingorder:
                startpendingscreen();
                finish();
                break;


            case R.id.logout:
                dialog = logout();
                dialog.show();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void startamendscheduler() {
        Intent intent = new Intent(MyProfile.this, AmendScheduler.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }

    private void startamendorder() {
        Intent intent = new Intent(MyProfile.this, AmendOrder.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }

    private void contactus() {
        Intent intent = new Intent(MyProfile.this, ContactUs.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }

    private void neworder() {
        Intent intent = new Intent(MyProfile.this, NewOrder.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        finish();
    }

    private void startpendingscreen() {
        Intent intent = new Intent(MyProfile.this, PendingOrder.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        finish();
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
            txtDateOfBirth.setText(dateTimeUtils.update(year, month, day));
        }
    }

    /**
     *
     */
    private void showDatePickerDialog() {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    private void startAboutUs() {
        Intent intent = new Intent(MyProfile.this, AboutUs.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }


    private void startHomeScreen() {
        Intent intent = new Intent(MyProfile.this, JustOLM.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }
}
