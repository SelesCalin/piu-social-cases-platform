package com.piu.socialcase.fragment.homepage;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.piu.socialcase.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TestsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TestsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TestsFragment extends Fragment {

    public TestsFragment() {
        // Required empty public constructor
    }
    public static TestsFragment newInstance() {
        TestsFragment fragment = new TestsFragment();
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
        return inflater.inflate(R.layout.fragment_tests, container, false);
    }
}
