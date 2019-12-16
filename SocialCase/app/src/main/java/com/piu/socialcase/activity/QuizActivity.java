package com.piu.socialcase.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.piu.socialcase.R;
import com.piu.socialcase.model.Test;

public class QuizActivity extends AppCompatActivity {

    private Test test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Intent intent=getIntent();

        TextView textView=findViewById(R.id.questions);
        this.test= (Test)intent.getSerializableExtra("test");
        textView.setText(test.getQuestions().get(1).getQuestion());
    }
}
