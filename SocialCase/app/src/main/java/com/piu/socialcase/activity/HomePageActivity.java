package com.piu.socialcase.activity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.piu.socialcase.R;
import com.piu.socialcase.fragment.homepage.AskForHelpFragment;
import com.piu.socialcase.fragment.homepage.HistoryFragment;
import com.piu.socialcase.fragment.homepage.ProfileFragment;
import com.piu.socialcase.fragment.homepage.ProgramFragment;
import com.piu.socialcase.fragment.homepage.TestsFragment;
import com.piu.socialcase.model.Volunteer;
import com.piu.socialcase.authentication.Session;

public class HomePageActivity extends AppCompatActivity {

    public static final String VOLUNTEER_EXTRA = "LoggedVolunteer";
    private Volunteer loggedVolunteer;
    BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;
    private int fragmentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLoggedVolunteer();
        setContentView(R.layout.activity_home_page);
        bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ProfileFragment()).commit();
    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment=null;
                    switch (item.getItemId()) {
                        case R.id.home_page_button:
                            selectedFragment = new ProfileFragment();
                            break;
                        case R.id.test_page_button:
                            selectedFragment = new TestsFragment();
                            break;
                        case R.id.program_zi_page_button:
                            selectedFragment = new ProgramFragment();
                            break;
                        case R.id.istoric_page_button:
                            selectedFragment = new HistoryFragment();
                            break;
                        case R.id.more_help_button:
                            selectedFragment = new AskForHelpFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();

                    return true;
                }
            };
    private void setLoggedVolunteer() {
        Session session=Session.getInstance();
        loggedVolunteer=session.getLoggedInUser();
    }



}
