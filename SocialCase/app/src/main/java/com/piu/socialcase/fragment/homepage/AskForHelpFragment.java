package com.piu.socialcase.fragment.homepage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.piu.socialcase.R;

public class AskForHelpFragment extends Fragment {

    public AskForHelpFragment() {
        // Required empty public constructor
    }

    public static AskForHelpFragment newInstance() {
        AskForHelpFragment fragment = new AskForHelpFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ask_for_help, container, false);
    }
}
