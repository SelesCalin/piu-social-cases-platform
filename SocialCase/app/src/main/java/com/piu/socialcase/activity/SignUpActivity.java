package com.piu.socialcase.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.piu.socialcase.R;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        TextView textView=findViewById(R.id.signIn_text);
        textView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                goToSignIn(v);
            }
        });

    }


    public void goToSignIn(View view) {
        Intent intent= new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(intent);
        finish();

    }

}
