package com.piu.socialcase.fragment.homepage;


import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.piu.socialcase.R;
import com.piu.socialcase.activity.HomePageActivity;
import com.piu.socialcase.model.TypeHelp;
import com.piu.socialcase.model.Volunteer;
import com.piu.socialcase.authentication.Session;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    public static final String VOLUNTEER_PARAM = "volunteer";

    private Volunteer volunteer;
    private TextView nameTextView;
    private TextView emailTextView;
    private TextView phoneTextView;
    private TextView birthDayTextView;
    private TextView organisationTextView;
    private TextView fullNameTextView;
    private TextView addressTextView;

    private Button helpNotification;
    private Button sosNotification;
    private Button batteryNotification;
    private Button askForHelpNotification;
    private Button medicationNotification;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        volunteer= Session.getInstance().getLoggedInUser();

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onStart() {
        super.onStart();
//        HomePageActivity  activity = (HomePageActivity) getActivity();
//        activity.getNotification();
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
        fullNameTextView=view.findViewById(R.id.full_name_text);
        phoneTextView=view.findViewById(R.id.phone_profile_text);
        addressTextView=view.findViewById(R.id.address_profile_text);
        birthDayTextView=view.findViewById(R.id.birthday_profile_text);
        organisationTextView=view.findViewById(R.id.profile_organization_text);

        setVolunteerInfo();

        helpNotification = view.findViewById(R.id.buttonHelp);
        sosNotification = view.findViewById(R.id.buttonSOS);
        batteryNotification = view.findViewById(R.id.buttonBattery);
        askForHelpNotification = view.findViewById(R.id.buttonAskForHelp);
        medicationNotification = view.findViewById(R.id.buttonMedicamentation);

        helpNotification.setOnClickListener(this);
        sosNotification.setOnClickListener(this);
        batteryNotification.setOnClickListener(this);
        askForHelpNotification.setOnClickListener(this);
        medicationNotification.setOnClickListener(this);

    }

    private void setVolunteerInfo() {

        emailTextView.setText(volunteer.getEmail());
        nameTextView.setText(volunteer.getUsername());
        fullNameTextView.setText(volunteer.getFullName());
        phoneTextView.setText(volunteer.getPhoneNumber());
        addressTextView.setText(volunteer.getAddress());
        birthDayTextView.setText(volunteer.getBirthDate());
        String organization=volunteer.getOrganisation();
        if (volunteer.getAccepted()==0) {
            organisationTextView.setText("Waiting for acceptance at " + organization);
        } else if(volunteer.getAccepted()==1){
            organisationTextView.setText(organization);
        } else if (volunteer.getAccepted() == -1) {
            organisationTextView.setText("Denied by "+organization+". Please select another organization");
        }

    }


    private String getNameInitials(String fullName){

        String[] names = fullName.split("[ -]");
        StringBuilder nameInitialsBuilder = new StringBuilder();
        for(String name: names)
            nameInitialsBuilder.append(name.charAt(0));

        return nameInitialsBuilder.toString();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View v) {
        HomePageActivity  activity = (HomePageActivity) getActivity();
        switch (v.getId()) {
            case R.id.buttonHelp:
                activity.sendNotification(TypeHelp.HELP);
                break;
            case R.id.buttonSOS:
                activity.sendNotification(TypeHelp.SOS);
                break;
            case R.id.buttonBattery:
                activity.sendNotification(TypeHelp.BATTERY);
                break;
            case R.id.buttonAskForHelp:
                activity.sendNotification(TypeHelp.ASKFORHELP);
                break;
            case R.id.buttonMedicamentation:
                activity.sendNotification(TypeHelp.MEDICATION);
                break;
        }

    }
}
