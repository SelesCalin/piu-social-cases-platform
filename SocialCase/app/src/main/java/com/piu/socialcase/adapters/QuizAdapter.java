package com.piu.socialcase.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.piu.socialcase.R;
import com.piu.socialcase.adapters.holders.QuestionHolder;
import com.piu.socialcase.model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuizAdapter extends RecyclerView.Adapter<QuestionHolder> {

    private List<Question> questionList;
    private Context context;
    private List<QuestionHolder> questionHolders;


    public QuizAdapter(Context context, List<Question> questions){
        this.context=context;
        this.questionList=questions;
        questionHolders=new ArrayList<>();
    }


    @NonNull
    @Override
    public QuestionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        return new QuestionHolder(inflater.inflate(R.layout.question_layout,parent,false));
        
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionHolder holder, int position) {
                    questionHolders.add(holder);
                     holder.bind(questionList.get(position));

    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }


    public List<QuestionHolder> getQuestionHolders(){
        return questionHolders;
    }
}
