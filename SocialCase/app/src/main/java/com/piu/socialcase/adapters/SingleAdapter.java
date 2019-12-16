package com.piu.socialcase.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.piu.socialcase.R;
import com.piu.socialcase.model.Answer;

import java.util.ArrayList;

public class SingleAdapter extends RecyclerView.Adapter<SingleAdapter.AnswersHolder> {

    private Context context;
    private ArrayList<Answer> answers;


    private int checkedPosition=0;

    public SingleAdapter(Context context, ArrayList<Answer> answers){
        this.context=context;
        this.answers=answers;
    }

    public void setAnswears(ArrayList<Answer> answers)
        {
        this.answers=new ArrayList<>();
        this.answers=answers;
        notifyDataSetChanged();
        }
    @NonNull
    @Override
    public AnswersHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.answears_layout,parent,false);
        return new AnswersHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AnswersHolder holder, int position) {
        holder.bindViewHolder(answers.get(position));
    }

    @Override
    public int getItemCount() {
        return answers.size();
    }

    class AnswersHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private ImageView imageView;


        public AnswersHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.answear_text);
            imageView=itemView.findViewById(R.id.tic);

        }

        void bindViewHolder(final Answer answear){
                if(checkedPosition==-1) {
                    imageView.setVisibility(View.GONE);
                }else{
                    if (checkedPosition == getAdapterPosition()) {
                        imageView.setVisibility(View.VISIBLE);
                    } else {
                        imageView.setVisibility(View.GONE);
                    }
                }
            textView.setText(answear.getText());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imageView.setVisibility(View.VISIBLE);
                    if (checkedPosition != getAdapterPosition()) {
                        notifyItemChanged(checkedPosition);
                        checkedPosition = getAdapterPosition();
                    }
                }
            });
        }
    }

    public Answer getSelected() {
        if (checkedPosition != -1) {
            return answers.get(checkedPosition);
        }
        return null;
    }


}
