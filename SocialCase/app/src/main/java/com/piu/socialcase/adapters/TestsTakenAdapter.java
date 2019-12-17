package com.piu.socialcase.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.piu.socialcase.R;
import com.piu.socialcase.adapters.holders.TestTakenHolder;
import com.piu.socialcase.model.Test;

import java.util.List;

public class TestsTakenAdapter extends RecyclerView.Adapter<TestTakenHolder> {

    private List<Test> testList;
    private Context context;

    public TestsTakenAdapter(Context context, List<Test> tests){
        this.context=context;
        this.testList=tests;
    }

    @NonNull
    @Override
    public TestTakenHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new TestTakenHolder(inflater.inflate(R.layout.taken_tests_layout,parent,false));


    }

    @Override
    public void onBindViewHolder(@NonNull TestTakenHolder holder, int position) {
        holder.bindViewHolder(testList.get(position));
    }

    @Override
    public int getItemCount() {
        return testList.size();
    }

    public List<Test> getTestList(){
        return testList;
    }
}
