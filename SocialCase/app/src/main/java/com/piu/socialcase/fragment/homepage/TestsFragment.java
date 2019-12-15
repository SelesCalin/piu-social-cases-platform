package com.piu.socialcase.fragment.homepage;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.piu.socialcase.R;
import com.piu.socialcase.adapters.TestsAvailableAdapter;
import com.piu.socialcase.model.Test;
import com.piu.socialcase.model.Volunteer;
import com.piu.socialcase.authentication.Session;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TestsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TestsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TestsFragment extends Fragment {

    private RecyclerView recyclerViewAvailableTests;
    private TestsAvailableAdapter testsAvailableAdapter;
    private List<Test> availableTests;
    private Volunteer volunteer=null;

    public TestsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        volunteer= Session.getInstance().getLoggedInUser();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_tests, container, false);
        init(view);
        return view;
    }

    private void init(View view){
        recyclerViewAvailableTests=view.findViewById(R.id.available_tests_view);
        
    }
}
