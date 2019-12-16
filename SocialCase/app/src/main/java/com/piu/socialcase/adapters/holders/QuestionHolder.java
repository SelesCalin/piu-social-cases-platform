package com.piu.socialcase.adapters.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.piu.socialcase.model.Answer;

import java.util.ArrayList;

public class QuestionHolder extends RecyclerView.ViewHolder {


    private TextView questionText;
    private RecyclerView answears;

    private ArrayList<Answer> answers;


    public QuestionHolder(@NonNull View itemView) {
        super(itemView);
    }
}
