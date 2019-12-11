package com.piu.socialcase.activity;

import android.content.DialogInterface;
import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.piu.socialcase.R;
import com.piu.socialcase.authentication.AuthenticationResult;
import com.piu.socialcase.model.Volunteer;
import com.piu.socialcase.service.LoginService;
import com.piu.socialcase.service.Session;

public class LoginActivity extends AppCompatActivity {

    private static final String AUTHENTICATION_FAILED_TITLE = "Authentication Error";
    private static final String AUTHENTICATION_FAILED_MESSAGE = "Wrong username and password";

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    private LoginService loginService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        loginService = LoginService.LoginService();
        initializeViews();
    }

    private void initializeViews() {
        usernameEditText = findViewById(R.id.login_username_edit_text);
        passwordEditText = findViewById(R.id.login_password_edit_text);
        loginButton = findViewById(R.id.login_login_button);

        TextView textView=findViewById(R.id.signUp_text);
        textView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                goToSignUp(v);
            }
        });
        setLoginButtonActionListener();
    }

    private void goToSignUp(View v) {
        Intent intent= new Intent(getApplicationContext(),SignUpActivity.class);
        startActivityForResult(intent,0);
    }

    private void setLoginButtonActionListener(){
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                AuthenticationResult authenticationResult = loginService.login(username, password);

                if(authenticationResult.hasError())
                    loginUnsuccessfulDialogBox();
                else {
                    resetCredentials();
                    goToHomePage(authenticationResult.getResult());
                }
            }
        });
    }

    private void resetCredentials() {
        usernameEditText.setText("");
        passwordEditText.setText("");
    }

    private void goToHomePage(Volunteer volunteer) {
        Intent intent = new Intent(this, HomePageActivity.class);
        Session session=Session.getInstance();
        session.setLoggedInUser(volunteer);
        startActivity(intent);
    }

    private void loginUnsuccessfulDialogBox(){
        new MaterialAlertDialogBuilder(this,R.style.dialogThemeError).setTitle(AUTHENTICATION_FAILED_TITLE).setMessage(AUTHENTICATION_FAILED_MESSAGE).setPositiveButton("Ok",null).show();

    }

}
