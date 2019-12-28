package com.piu.socialcase.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.piu.socialcase.R;
import com.piu.socialcase.adapters.QuizAdapter;
import com.piu.socialcase.adapters.holders.QuestionHolder;
import com.piu.socialcase.model.Test;
import com.piu.socialcase.service.TestsService;

import java.util.Timer;
import java.util.TooManyListenersException;

public class QuizActivity extends AppCompatActivity {

    private Test test;
    private RecyclerView recyclerView;
    private TextView title;
    private QuizAdapter adapter;
    private Button startButton;
    private TextView timeRemaining;
    private Button cancelButton;
    private Button submitButton;
    private TestsService testsService;
    private CountDownTimer timer;
    private Context context;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Intent intent=getIntent();
        context=this;
        testsService=TestsService.TestService();
        startButton=findViewById(R.id.buton_start);
        timeRemaining=findViewById(R.id.time_remaining);
        cancelButton=findViewById(R.id.cancel_test);
        submitButton=findViewById(R.id.buton_finish);
        title=findViewById(R.id.test_title);
        recyclerView=findViewById(R.id.questions);
        this.test= (Test)intent.getSerializableExtra("test");

        title.setText(new StringBuilder().append("Test ").append(test.getTestNo()).toString());
        timeRemaining.setText("You have: " + test.getTime()+ " minutes to complete the test");
        cancelButton.setVisibility(View.GONE);
        submitButton.setVisibility(View.GONE);
        adapter=new QuizAdapter(this,test.getQuestions());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setVisibility(View.INVISIBLE);

        setClickListeners();
    }

    private void setClickListeners() {

    startButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            recyclerView.setVisibility(View.VISIBLE);
            cancelButton.setVisibility(View.VISIBLE);
            submitButton.setVisibility(View.VISIBLE);
            timeRemaining.setTextColor(Color.RED);
            timeRemaining.setTextSize(30);
            Integer time=test.getTime()*60;
            startButton.setVisibility(View.GONE);
             timer = new CountDownTimer(time*1000,1000) {
                @Override
                public void onTick(long l) {
                    int seconds = (int) (l / 1000) % 60;
                    if (seconds > 9) {
                        timeRemaining.setText((int) (l / 1000) / 60 + ":" + seconds);
                    } else {
                        timeRemaining.setText((int) (l / 1000) / 60 + ": 0" + seconds);

                    }
                }

                @Override
                public void onFinish() {
                    cancelButton.setVisibility(View.INVISIBLE);
                }
            }.start();
        }
    });


    submitButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int result = calculateResult();
            System.out.println(result);
            testsService.setTestTaken(test,result);
            goToHomePage();
        }

    });

    cancelButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            MaterialAlertDialogBuilder dialogInterface= new MaterialAlertDialogBuilder(context,R.style.dialogThemeError).setTitle("Are you sure you want to cancel?").setMessage("Test result will not be saved!");
            dialogInterface.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    goToHomePage();
                }
            });

            dialogInterface.setNegativeButton("Stay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            dialogInterface.show();

        }
    });
    }



    public int calculateResult(){
        int result=0;
        for(QuestionHolder q: adapter.getQuestionHolders()) {
               result+= q.getAnswear();
        }
        return result;
    }

    public void goToHomePage(){
        Intent intent= new Intent(this,HomePageActivity.class);
        startActivity(intent);
        finish();
    }
}
