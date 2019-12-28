package com.piu.socialcase.activity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.piu.socialcase.R;
import com.piu.socialcase.fragment.homepage.AskForHelpFragment;
import com.piu.socialcase.fragment.homepage.HistoryFragment;
import com.piu.socialcase.fragment.homepage.ProfileFragment;
import com.piu.socialcase.fragment.homepage.ProgramFragment;
import com.piu.socialcase.fragment.homepage.TestsFragment;
import com.piu.socialcase.model.Volunteer;
import com.piu.socialcase.authentication.Session;

public class HomePageActivity extends AppCompatActivity implements View.OnClickListener  {

    public static final String VOLUNTEER_EXTRA = "LoggedVolunteer";
    private Volunteer loggedVolunteer;
    BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;
    private int fragmentId;
    public Button pendingCases, currentCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLoggedVolunteer();
        setContentView(R.layout.activity_home_page);
        bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ProfileFragment()).commit();
        pendingCases = findViewById(R.id.pendingCases);
        currentCase = findViewById(R.id.currentCase);
        pendingCases.setOnClickListener(this);
        currentCase.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pendingCases:
                Toast.makeText(getApplicationContext(),"Pending Cases",Toast.LENGTH_SHORT).show();
                break;
            case R.id.currentCase:
                Intent intent = new Intent(this, MapActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Current Case",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if ( v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent( event );
    }
}
