package com.piu.socialcase.adapters.holders;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.piu.socialcase.R;
import com.piu.socialcase.adapters.SingleAdapter;
import com.piu.socialcase.model.Answer;
import com.piu.socialcase.model.Question;

import java.util.ArrayList;

public class QuestionHolder extends RecyclerView.ViewHolder {


    private TextView questionText;
    private RecyclerView answears;
    private SingleAdapter singleAdapter;
    private Context context;


    public QuestionHolder(@NonNull View itemView) {
        super(itemView);
        questionText=itemView.findViewById(R.id.questions_text);
        answears=itemView.findViewById(R.id.answers);
        context=itemView.getContext();
        }


    public void bind(Question question){
        questionText.setText(question.getQuestion());
        singleAdapter=new SingleAdapter(context, new ArrayList<Answer>(question.getAnswears()));
        answears.setAdapter(singleAdapter);
        answears.setLayoutManager(new LinearLayoutManager(context));

    }

    public int getAnswear(){
        Answer answer = singleAdapter.getSelected();
        if(answer==null) {
            return 0;
        }
        if(answer.getCorrect())
            return 1;
        else
            return 0;

    }
}
