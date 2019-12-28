package com.piu.socialcase.adapters.holders;

import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.piu.socialcase.R;
import com.piu.socialcase.model.Test;

import java.time.format.DateTimeFormatter;


public class TestTakenHolder extends RecyclerView.ViewHolder {

    private TextView testNumber;
    private ImageView iconTest;
    private TextView passedOrNot;
    private TextView result;
    private TextView taken_date;

    public TestTakenHolder(@NonNull View itemView) {
        super(itemView);
        testNumber=itemView.findViewById(R.id.test_number);
        iconTest=itemView.findViewById(R.id.icon_test);
        passedOrNot=itemView.findViewById(R.id.passed_or_not);
        result=itemView.findViewById(R.id.result);
        taken_date=itemView.findViewById(R.id.taken_date);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void bindViewHolder(final Test test){
        testNumber.setText(new StringBuilder().append("Test ").append(test.getTestNo()).toString());
        if(test.getCorrectAnswers()>(test.getQuestions().size()/2)) {
            passedOrNot.setText("Passed");
            passedOrNot.setTextColor(Color.parseColor("#00ff00"));
            iconTest.setImageResource(R.drawable.ic_sentiment_very_satisfied_black);
        }else {
            passedOrNot.setText("Failed");
            passedOrNot.setTextColor(Color.parseColor("#FF0000"));
            iconTest.setImageResource(R.drawable.ic_sentiment_dissatisfied_black_24dp);
        }
        result.setText(new StringBuilder().append(test.getCorrectAnswers()).append("/").append(test.getQuestions().size()));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        taken_date.setText(test.getDayTaken().format(formatter));
    }
}
