package com.piu.socialcase.adapters.holders;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.piu.socialcase.R;
import com.piu.socialcase.activity.QuizActivity;
import com.piu.socialcase.model.Test;

import java.io.Serializable;


public class TestAvailableHolder extends RecyclerView.ViewHolder {


    private TextView testNumber;
    private TextView questionNumber;
    private TextView timeForTest;
    private Button takeTest;


    public TestAvailableHolder(@NonNull View itemView) {
        super(itemView);

        testNumber= itemView.findViewById(R.id.test_number);
        questionNumber=itemView.findViewById(R.id.questions);
        timeForTest=itemView.findViewById(R.id.timeForTest);
        takeTest=itemView.findViewById(R.id.butonTakeTest);
    }

    public void bindViewHolder(final Test test, final Context context) {

        testNumber.setText(new StringBuilder().append("Test ").append(test.getTestNo()).toString());
        questionNumber.setText(new StringBuilder().append(test.getQuestions().size()).append(" questions"));
        timeForTest.setText(new StringBuilder().append(test.getTime().toString()).append(" minutes"));
        takeTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(view.getContext(), QuizActivity.class);
                intent.putExtra("test",(Serializable) test);
                context.startActivity(intent);
            }
        });


    }


}
