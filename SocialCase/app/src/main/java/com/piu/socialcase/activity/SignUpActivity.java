package com.piu.socialcase.activity;


import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.piu.socialcase.R;
import com.piu.socialcase.service.LoginService;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SignUpActivity extends AppCompatActivity {

    final Calendar calendar=Calendar.getInstance();
    EditText birthdayText;
    Button butonSubmit;
    TextInputLayout floatingUsernameLabel ;
    TextInputLayout floatingPasswordLabel;
    TextInputLayout floatingConfirmPasswordLabel;
    TextInputLayout floatingEmailLabel;
    TextInputLayout floatinNameLabel;
    TextInputLayout floatingAddressLabel;
    TextInputLayout floatingPhoneLabel;
    TextInputLayout floatingBirthdayLabel;
    LoginService loginService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        birthdayText= (EditText) findViewById(R.id.birthday);
        floatingUsernameLabel =(TextInputLayout) findViewById(R.id.username_text_input_layout);
        floatingPasswordLabel =(TextInputLayout) findViewById(R.id.password_text_input_layout);
        floatingConfirmPasswordLabel=(TextInputLayout) findViewById(R.id.confirm_text_input_layout);
        floatingEmailLabel=(TextInputLayout) findViewById(R.id.email_text_input_layout);
        floatinNameLabel=(TextInputLayout) findViewById(R.id.name_text_input_layout);
        floatingPhoneLabel=(TextInputLayout) findViewById(R.id.phone_text_input_layout);
        floatingBirthdayLabel =(TextInputLayout) findViewById(R.id.birthday_text_input_layout);
        floatingAddressLabel=(TextInputLayout) findViewById(R.id.address_text_input_layout);
        setupFloatingLabelError();
        setCalendarListener();
        setClickListeners();
        loginService=LoginService.LoginService();

    }

    private void setClickListeners() {
        TextView textView=findViewById(R.id.signIn_text);
        textView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                goToSignIn(v);
            }
        });
        butonSubmit = findViewById(R.id.butonSignUp);
        butonSubmit.setEnabled(false);
        butonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSignUp();
            }
        });
    }

    private void onSignUp() {
        Integer signUpResult=loginService.signUp(floatingUsernameLabel.getEditText().getText().toString(),floatingPasswordLabel.getEditText().getText().toString(),
                floatingConfirmPasswordLabel.getEditText().getText().toString(),floatingEmailLabel.getEditText().getText().toString(),
                floatingPhoneLabel.getEditText().getText().toString(),floatingAddressLabel.getEditText().getText().toString(),
                floatingBirthdayLabel.getEditText().getText().toString());
        System.out.println(signUpResult);


    }


    private void signUpUnsuccessfullDialog(String error){

    }


    public void goToSignIn(View view) {
        Intent intent= new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(intent);
        finish();

    }

    private void setCalendarListener(){

        final DatePickerDialog.OnDateSetListener date= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(Calendar.YEAR,i);
                calendar.set(Calendar.MONTH,i1);
                calendar.set(Calendar.DAY_OF_MONTH,i2);
                updateLabels();
            }
        };

        birthdayText.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                new DatePickerDialog(SignUpActivity.this,date,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void updateLabels() {
        Calendar today= Calendar.getInstance();

        long diff= today.getTimeInMillis()-calendar.getTimeInMillis();
        long years=diff/(24*60*60*1000*365);
        if(years<18) {
            floatingBirthdayLabel.setError("Must be over 18");
        }else {
            floatingBirthdayLabel.setError(null);
        }
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);
        birthdayText.setText(sdf.format(calendar.getTime()));
        checkFieldsForEmptyValues();
    }

    private void setupFloatingLabelError(){




        floatingUsernameLabel.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener(){

            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b) {
                    if(floatingUsernameLabel.getEditText().getText().length()>0 && floatingUsernameLabel.getEditText().getText().length()<4) {
                        floatingUsernameLabel.setError("Username must have at least 4 characters");
                    }else {
                        floatingUsernameLabel.setError(null);
                    }
                    checkFieldsForEmptyValues();
                }
            }
        });



        floatingPasswordLabel.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener(){

            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b) {
                    if(floatingPasswordLabel.getEditText().getText().length()>0 && floatingPasswordLabel.getEditText().getText().length()<4) {
                        floatingPasswordLabel.setError("Password must have at least 4 characters");
                    }else {
                        floatingPasswordLabel.setError(null);
                    }
                    checkFieldsForEmptyValues();
                }
            }
        });

        floatingEmailLabel.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener(){

            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b) {
                    if(floatingEmailLabel.getEditText().getText().length()>0 && !Patterns.EMAIL_ADDRESS.matcher(floatingEmailLabel.getEditText().getText()).matches()) {
                        floatingEmailLabel.setError("Email is not valid");


                    }else {
                        floatingEmailLabel.setError(null);
                    }
                    checkFieldsForEmptyValues();
                }
            }
        });


        floatinNameLabel.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener(){

            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b) {
                    if(floatinNameLabel.getEditText().getText().length()>0 && floatinNameLabel.getEditText().getText().length()<4) {
                        floatinNameLabel.setError("Name must contain at least 4 characters");
                    }else {
                        floatinNameLabel.setError(null);
                    }
                    checkFieldsForEmptyValues();
                }
            }
        });



        floatingPhoneLabel.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener(){

            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b) {
                    if(floatingPhoneLabel.getEditText().getText().length()>0 && !Patterns.PHONE.matcher(floatingPhoneLabel.getEditText().getText()).matches()) {
                        floatingPhoneLabel.setError("Invalid Phone number");

                    }else {
                        floatingPhoneLabel.setError(null);
                    }
                    checkFieldsForEmptyValues();
                }
            }
        });
    }


    void checkFieldsForEmptyValues(){

        boolean usernameCorrect=TextUtils.isEmpty(floatingUsernameLabel.getError()) && floatingUsernameLabel.getEditText().getText().length()>0;
        boolean emailCorrect=TextUtils.isEmpty(floatingEmailLabel.getError()) && floatingEmailLabel.getEditText().getText().length()>0;
        boolean passwordCorrect=TextUtils.isEmpty(floatingPasswordLabel.getError()) && floatingPasswordLabel.getEditText().getText().length()>0;
        boolean nameCorrect=TextUtils.isEmpty(floatinNameLabel.getError()) && floatinNameLabel.getEditText().getText().length()>0;
        boolean phoneCorrect=TextUtils.isEmpty(floatinNameLabel.getError()) && floatinNameLabel.getEditText().getText().length()>0;
        boolean birthDayCorrect=TextUtils.isEmpty(floatingBirthdayLabel.getError()) && floatingBirthdayLabel.getEditText().getText().length()>0;

        if(usernameCorrect && emailCorrect && passwordCorrect && nameCorrect && phoneCorrect && birthDayCorrect) {
            butonSubmit.setEnabled(true);
        }else {
            butonSubmit.setEnabled(false);
        }

    }
}
