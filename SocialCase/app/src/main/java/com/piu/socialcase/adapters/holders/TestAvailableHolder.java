package com.piu.socialcase.adapters.holders;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.piu.socialcase.R;
import com.piu.socialcase.model.Test;


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

    public void bindViewHolder(final Test test) {

        testNumber.setText(new StringBuilder().append("Test ").append(test.getTestNo()).toString());
        questionNumber.setText(new StringBuilder().append(test.getQuestions().size()).append(" questions"));
        timeForTest.setText(test.getTime().toString());
    }
}
