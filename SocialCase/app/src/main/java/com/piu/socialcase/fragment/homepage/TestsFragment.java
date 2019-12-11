package com.piu.socialcase.fragment.homepage;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.piu.socialcase.R;
import com.piu.socialcase.model.Volunteer;
import com.piu.socialcase.authentication.Session;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TestsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TestsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TestsFragment extends Fragment {


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
        return inflater.inflate(R.layout.fragment_tests, container, false);
    }
}
