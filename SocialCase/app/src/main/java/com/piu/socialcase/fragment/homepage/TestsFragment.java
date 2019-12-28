package com.piu.socialcase.fragment.homepage;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.piu.socialcase.R;
import com.piu.socialcase.adapters.TestsAvailableAdapter;
import com.piu.socialcase.adapters.TestsTakenAdapter;
import com.piu.socialcase.model.Test;
import com.piu.socialcase.model.Volunteer;
import com.piu.socialcase.authentication.Session;
import com.piu.socialcase.service.TestsService;

import java.util.List;

import static com.piu.socialcase.service.TestsService.TestService;

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
    private RecyclerView recyclerViewTakenTests;
    private TestsTakenAdapter testsTakenAdapter;
    private TestsAvailableAdapter testsAvailableAdapter;
    private List<Test> availableTests;
    private List<Test> takenTests;

    private Volunteer volunteer=null;
    private TestsService testsService;

    public TestsFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        volunteer= Session.getInstance().getLoggedInUser();
        testsService= TestService();



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
        availableTests=testsService.getAllAvailableTests();
        testsAvailableAdapter=new TestsAvailableAdapter(getContext(),availableTests);
        recyclerViewAvailableTests.setAdapter(testsAvailableAdapter);
        recyclerViewAvailableTests.setLayoutManager(new LinearLayoutManager(getContext()));


        //2nd recycler
        recyclerViewTakenTests=view.findViewById(R.id.history_tests_view);
        takenTests=testsService.getAllTakenTests();
        testsTakenAdapter=new TestsTakenAdapter(getContext(),takenTests);
        recyclerViewTakenTests.setAdapter(testsTakenAdapter);
        recyclerViewTakenTests.setLayoutManager(new LinearLayoutManager(getContext()));



    }
}
