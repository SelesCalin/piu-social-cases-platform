package com.piu.socialcase.fragment.homepage;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.piu.socialcase.R;
import com.piu.socialcase.model.Volunteer;
import com.piu.socialcase.service.Session;

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
        iconTextView = view.findViewById(R.id.volunteer_info_volunteer_icon);
        nameTextView = view.findViewById(R.id.volunteer_info_name);
        emailTextView = view.findViewById(R.id.volunteer_info_email);
        phoneTextView = view.findViewById(R.id.volunteer_info_phone);
        organisationTextView = view.findViewById(R.id.volunteer_info_organisation);

        setVolunteerInfo();
    }

    private void setVolunteerInfo() {
        iconTextView.setText(getNameInitials(volunteer.getUsername()));
        nameTextView.setText(volunteer.getUsername());
        emailTextView.setText(volunteer.getEmail());
        phoneTextView.setText(volunteer.getPhoneNumber());
        organisationTextView.setText(volunteer.getOrganisation());
    }


    private String getNameInitials(String fullName){

        String[] names = fullName.split("[ -]");
        StringBuilder nameInitialsBuilder = new StringBuilder();
        for(String name: names)
            nameInitialsBuilder.append(name.charAt(0));

        return nameInitialsBuilder.toString();
    }
}
