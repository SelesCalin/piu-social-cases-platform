package com.piu.socialcase.activity;

import android.content.Intent;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.piu.socialcase.R;
import com.piu.socialcase.fragment.homepage.AskForHelpFragment;
import com.piu.socialcase.fragment.homepage.HistoryFragment;
import com.piu.socialcase.fragment.homepage.ProfileFragment;
import com.piu.socialcase.fragment.homepage.ProgramFragment;
import com.piu.socialcase.fragment.homepage.TestsFragment;
import com.piu.socialcase.model.Volunteer;

public class HomePageActivity extends AppCompatActivity {

    public static final String VOLUNTEER_EXTRA = "LoggedVolunteer";

    private Volunteer loggedVolunteer;

    private Button profileButton;
    private Button testsButton;
    private Button programButton;
    private Button historyButton;
    private Button askForHelpButton;

    private FragmentManager fragmentManager;
    private int fragmentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setLoggedVolunteer();
        setContentView(R.layout.activity_home_page);
        initializeViews();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(fragmentId, ProfileFragment.newInstance(loggedVolunteer));
        fragmentTransaction.commit();
    }

    private void setLoggedVolunteer() {
        Intent intent = getIntent();
        loggedVolunteer = (Volunteer) intent.getSerializableExtra(VOLUNTEER_EXTRA);
    }

    private void initializeViews() {

        fragmentId = R.id.home_page_selected_fragment;

        profileButton = findViewById(R.id.home_page_buttons_profile_button);
        testsButton = findViewById(R.id.home_page_buttons_tests_button);
        programButton = findViewById(R.id.home_page_buttons_program_button);
        historyButton= findViewById(R.id.home_page_buttons_history_button);
        askForHelpButton = findViewById(R.id.home_page_buttons_ask_for_help_button);

        addButtonsOnClickListeners();
    }

    private void addButtonsOnClickListeners() {

        profileButton.setOnClickListener(new ProfileButtonClickListener());
        testsButton.setOnClickListener(new TestsButtonOnClickListener());
        programButton.setOnClickListener(new ProgramButtonOnClickListener());
        historyButton.setOnClickListener(new HistoryButtonOnClickListener());
        askForHelpButton.setOnClickListener(new AskForHelpButtonOnClickListener());
    }

    private class ProfileButtonClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(fragmentId, ProfileFragment.newInstance(loggedVolunteer));
            fragmentTransaction.commit();
        }
    }

    private class TestsButtonOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(fragmentId, TestsFragment.newInstance());
            fragmentTransaction.commit();
        }
    }

    private class ProgramButtonOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(fragmentId, ProgramFragment.newInstance());
            fragmentTransaction.commit();
        }
    }

    private class HistoryButtonOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(fragmentId, HistoryFragment.newInstance());
            fragmentTransaction.commit();
        }
    }

    private class AskForHelpButtonOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(fragmentId, AskForHelpFragment.newInstance());
            fragmentTransaction.commit();
        }
    }
}
