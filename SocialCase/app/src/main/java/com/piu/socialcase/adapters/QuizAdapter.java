package com.piu.socialcase.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.piu.socialcase.R;
import com.piu.socialcase.adapters.holders.QuestionHolder;
import com.piu.socialcase.model.Question;

import java.util.List;

public class QuizAdapter extends RecyclerView.Adapter<QuestionHolder> {

    private List<Question> questionList;
    private Context context;


    public QuizAdapter(Context context, List<Question> questions){
        this.context=context;
        this.questionList=questions;
    }


    @NonNull
    @Override
    public QuestionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        return new QuestionHolder(inflater.inflate(R.layout.question_layout,parent,false));
        
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionHolder holder, int position) {
                     holder.bind(questionList.get(position));

    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }
}
