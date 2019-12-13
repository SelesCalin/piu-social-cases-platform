package com.piu.socialcase.fragment.homepage;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.piu.socialcase.R;
import com.piu.socialcase.model.Volunteer;
import com.piu.socialcase.authentication.Session;

import java.util.Arrays;

public class ProfileFragment extends Fragment {

    public static final String VOLUNTEER_PARAM = "volunteer";

    private Volunteer volunteer;
    private TextView iconTextView;
    private TextView nameTextView;
    private TextView emailTextView;
    private TextView phoneTextView;
    private TextView organisationTextView;

    public ProfileFragment() {
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
        View fragmentView = inflater.inflate(R.layout.fragment_profile, container, false);
        if(volunteer != null)
            initializeViews(fragmentView);
        return fragmentView;
    }

    private void initializeViews(View view) {
        nameTextView=view.findViewById(R.id.profile_name_text);
        emailTextView=view.findViewById(R.id.profile_email_text);


       setVolunteerInfo();
    }

    private void setVolunteerInfo() {
        emailTextView.setText(volunteer.getEmail());
        nameTextView.setText(volunteer.getUsername());
    }


    private String getNameInitials(String fullName){

        String[] names = fullName.split("[ -]");
        StringBuilder nameInitialsBuilder = new StringBuilder();
        for(String name: names)
            nameInitialsBuilder.append(name.charAt(0));

        return nameInitialsBuilder.toString();
    }
}
