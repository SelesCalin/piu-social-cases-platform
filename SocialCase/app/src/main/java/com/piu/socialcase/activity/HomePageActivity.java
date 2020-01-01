package com.piu.socialcase.activity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.piu.socialcase.R;
import com.piu.socialcase.authentication.Session;
import com.piu.socialcase.fragment.homepage.AskForHelpFragment;
import com.piu.socialcase.fragment.homepage.HistoryFragment;
import com.piu.socialcase.fragment.homepage.ProfileFragment;
import com.piu.socialcase.fragment.homepage.ProgramFragment;
import com.piu.socialcase.fragment.homepage.TestsFragment;
import com.piu.socialcase.model.Help;
import com.piu.socialcase.model.Volunteer;
import com.piu.socialcase.service.SocialCaseService;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

public class HomePageActivity extends AppCompatActivity implements View.OnClickListener  {

    public static final String VOLUNTEER_EXTRA = "LoggedVolunteer";
    private Volunteer loggedVolunteer;
    BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;
    private int fragmentId;
    public Button pendingCases, currentCase;
    private SocialCaseService socialCaseService;
    Notification notification;
    private Timer timer;
    Context context;
    Help help;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLoggedVolunteer();
        setContentView(R.layout.activity_home_page);
        context = this;
        bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        pendingCases = findViewById(R.id.pendingCases);
        currentCase = findViewById(R.id.currentCase);
        pendingCases.setOnClickListener(this);
        currentCase.setOnClickListener(this);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ProfileFragment()).commit();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onStart() {
        super.onStart();
        getNotification();
        if(socialCaseService.getCurrentSocialCase(loggedVolunteer)==null){
            this.currentCase.setVisibility(View.GONE);
        }else{
            this.currentCase.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (timer != null) timer.cancel();
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.cancel(0);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void getNotification(){
        this.socialCaseService = SocialCaseService.SocialCaseService();
        if (timer != null) timer.cancel();
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.cancel(0);
        help = socialCaseService.getHelp();
        if(help!=null) {
            setNotification();
            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
                            notificationManager.notify(0, notification);
                        }
                    });
                }
            }, 10000, 10000);
        }
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
               // Intent intent = new Intent(this, MapActivity.class);
                Intent intent = new Intent(this, ProgramInAvansActivity.class);

                intent.putExtra("currentCase",(Serializable) socialCaseService.getCurrentSocialCase(loggedVolunteer));
                intent.putExtra("showButtons", (Serializable) false);
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void setNotification(){

        NotificationChannel channel = new NotificationChannel("channel01", "name",
                NotificationManager.IMPORTANCE_HIGH);   // for heads-up notifications
        channel.setDescription("description");

        // Register channel with system
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);

        Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra("currentCase",(Serializable) help);
        intent.putExtra("showButtons", (Serializable) true);
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        notification = new NotificationCompat.Builder(this, "channel01")
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle(help.getSocialCase().getName() + " needs help!")
                .setContentText(help.getType() + ",  "+ help.getDescription())
                .setDefaults(Notification.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH)   // heads-up
                .setContentIntent(activity)
                .build();

    }

}
