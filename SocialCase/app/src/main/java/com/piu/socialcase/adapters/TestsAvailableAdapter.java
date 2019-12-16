package com.piu.socialcase.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.piu.socialcase.R;
import com.piu.socialcase.adapters.holders.TestAvailableHolder;
import com.piu.socialcase.model.Test;

import java.util.List;

public class TestsAvailableAdapter extends RecyclerView.Adapter<TestAvailableHolder> {

    private List<Test> tests;
    private Context context;


    public TestsAvailableAdapter(Context context,List<Test> tests){
        this.context=context;
        this.tests=tests;
    }

    @NonNull
    @Override
    public TestAvailableHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        return new TestAvailableHolder(inflater.inflate(R.layout.available_tests_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TestAvailableHolder holder, int position) {
        holder.bindViewHolder(tests.get(position),context);

    }

    @Override
    public int getItemCount() {
        return tests.size();
    }


    public List<Test> getTests(){
        return tests;
    }

}
