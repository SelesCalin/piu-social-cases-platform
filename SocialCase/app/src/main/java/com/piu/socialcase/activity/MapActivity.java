package com.piu.socialcase.activity;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.piu.socialcase.R;
import com.piu.socialcase.authentication.Session;
import com.piu.socialcase.model.Help;
import com.piu.socialcase.model.History;
import com.piu.socialcase.model.Volunteer;
import com.piu.socialcase.service.HistoryService;
import com.piu.socialcase.service.SocialCaseService;
import com.piu.socialcase.utils.DirectionPointListener;
import com.piu.socialcase.utils.GetPathFromLocation;
import com.piu.socialcase.utils.PermissionUtils;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Random;


public class MapActivity extends AppCompatActivity
        implements
        GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnMyLocationClickListener,
        OnMapReadyCallback,
        ActivityCompat.OnRequestPermissionsResultCallback,
        View.OnClickListener {

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;

    private GoogleMap mMap;
    /**
     * Flag indicating whether a requested permission has been denied after returning in
     * {@link #onRequestPermissionsResult(int, String[], int[])}.
     */
    private boolean mPermissionDenied = false;
    LatLng socialCaseLocation;
    LatLng myLocation;
    LocationManager locationManager;
    Context mContext;
    Polyline polylineLast;
    Polyline polylineCurrent;

    boolean buttons;
    Help help;
    private TextView nameSocialCase;
    private TextView phoneSocialCase;
    private TextView addressSocialCase;
    private TextView descriptionSocialCase;
    private Button acceptButton;
    private Button rejectButton;
    private Button confirmPresence;
    private Button programInAdvance;
    private Button caseDoneButton;
    private Button dropButton;
    private ImageView imageView;

    private SocialCaseService socialCaseService;
    private HistoryService historyService;
    public static final String VOLUNTEER_EXTRA = "LoggedVolunteer";
    private Volunteer loggedVolunteer;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        setLoggedVolunteer();
        initiate();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mContext = this;
        locationManager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                2000,
                10, locationListenerGPS);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(help.isPresenceConfirmed()){
            acceptButton.setVisibility(View.GONE);
            rejectButton.setVisibility(View.GONE);
            confirmPresence.setVisibility(View.GONE);
            dropButton.setVisibility(View.GONE);
            caseDoneButton.setVisibility(View.VISIBLE);
            programInAdvance.setVisibility(View.VISIBLE);
            return;
        }

        if(!this.buttons){
            caseDoneButton.setVisibility(View.GONE);
            programInAdvance.setVisibility(View.GONE);
            acceptButton.setVisibility(View.GONE);
            rejectButton.setVisibility(View.GONE);
            confirmPresence.setVisibility(View.VISIBLE);
            dropButton.setVisibility(View.VISIBLE);
        }else{
            confirmPresence.setVisibility(View.GONE);
            programInAdvance.setVisibility(View.GONE);
            acceptButton.setVisibility(View.VISIBLE);
            rejectButton.setVisibility(View.VISIBLE);
            caseDoneButton.setVisibility(View.GONE);
            dropButton.setVisibility(View.GONE);
        }
    }

    private void setLoggedVolunteer() {
        Session session=Session.getInstance();
        loggedVolunteer=session.getLoggedInUser();

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void initiate(){
        this.socialCaseService = SocialCaseService.SocialCaseService();
        this.historyService = new HistoryService();
        Intent intent=getIntent();
        this.help = (Help)intent.getSerializableExtra("currentCase");
        this.buttons = (boolean)intent.getSerializableExtra("showButtons");

        nameSocialCase=findViewById(R.id.name_social_case);
        phoneSocialCase=findViewById(R.id.phone_social_case);
        addressSocialCase=findViewById(R.id.address_social_case);
        descriptionSocialCase=findViewById(R.id.description_social_case);
        descriptionSocialCase.setMovementMethod(new ScrollingMovementMethod());
        imageView = findViewById(R.id.description_social_case_icon);
        acceptButton=findViewById(R.id.accept_social_case);
        rejectButton=findViewById(R.id.reject_social_case);
        caseDoneButton=findViewById(R.id.case_done);
        confirmPresence=findViewById(R.id.confirm_presence_social_case);
        programInAdvance=findViewById(R.id.program_in_advance_social_case);
        dropButton=findViewById(R.id.drop_social_case);
        acceptButton.setOnClickListener(this);
        rejectButton.setOnClickListener(this);
        caseDoneButton.setOnClickListener(this);
        dropButton.setOnClickListener(this);
        confirmPresence.setOnClickListener(this);
        programInAdvance.setOnClickListener(this);
        imageView.setOnClickListener(this);

        nameSocialCase.setText(this.help.getSocialCase().getName());
        phoneSocialCase.setText(this.help.getSocialCase().getPhoneNumber());
        addressSocialCase.setText(this.help.getSocialCase().getAddress());
        descriptionSocialCase.setText(this.help.getType() + ", " + this.help.getDescription());

        this.socialCaseLocation = new LatLng(this.help.getSocialCase().getLatitude(),this.help.getSocialCase().getLongitude());
    }

    LocationListener locationListenerGPS=new LocationListener() {
        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public void onLocationChanged(android.location.Location location) {
            double latitude=location.getLatitude();
            double longitude=location.getLongitude();
            myLocation = new LatLng(latitude,longitude);
            drawRoute();
        }
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }
        @Override
        public void onProviderEnabled(String provider) {

        }
        @Override
        public void onProviderDisabled(String provider) {

        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        mMap.addMarker(new
                MarkerOptions().position(socialCaseLocation).title("Social Case"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(socialCaseLocation));

        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);
        enableMyLocation();

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(socialCaseLocation, 15.0f));
    }

    /**
     * Enables the My Location layer if the fine location permission has been granted.
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission to access the location is missing.
            PermissionUtils.requestPermission(this, LOCATION_PERMISSION_REQUEST_CODE,
                    Manifest.permission.ACCESS_FINE_LOCATION, true);
        } else if (mMap != null) {
            // Access to the location has been granted to the app.
            mMap.setMyLocationEnabled(true);
            LocationManager locationManager = (LocationManager)
                    getSystemService(Context.LOCATION_SERVICE);
            Criteria criteria = new Criteria();

            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    Activity#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for Activity#requestPermissions for more details.
                return;
            }
            Location location = locationManager.getLastKnownLocation(locationManager
                    .getBestProvider(criteria, false));

            double latitude = location.getLatitude();
            double longitude = location.getLongitude();
            myLocation = new LatLng(latitude, longitude);

            drawRoute();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void drawRoute() {
        LatLng source = myLocation;
        LatLng destination = socialCaseLocation;
        new GetPathFromLocation(source, destination, new DirectionPointListener() {
            @Override
            public void onPath(PolylineOptions polyLine) {
                polylineCurrent = mMap.addPolyline(polyLine);
            }
        }).execute();

        if (polylineLast!=null) polylineLast.remove();
        polylineLast = polylineCurrent;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();
        // Return false so that we don't consume the event and the default behavior still occurs
        // (the camera animates to the user's current position).
        LocationManager locationManager = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            return false;
        }
        Location location = locationManager.getLastKnownLocation(locationManager
                .getBestProvider(criteria, false));
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        myLocation = new LatLng(latitude, longitude);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myLocation, 15.0f));
        return false;
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(this, "Current location:\n" + location, Toast.LENGTH_LONG).show();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
            return;
        }

        if (PermissionUtils.isPermissionGranted(permissions, grantResults,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            // Enable the my location layer if the permission has been granted.
            enableMyLocation();
        } else {
            // Display the missing permission error dialog when the fragments resume.
            mPermissionDenied = true;
        }
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        if (mPermissionDenied) {
            // Permission was not granted, display error dialog.
            showMissingPermissionError();
            mPermissionDenied = false;
        }
    }

    /**
     * Displays a dialog with error message explaining that the location permission is missing.
     */
    private void showMissingPermissionError() {
        PermissionUtils.PermissionDeniedDialog
                .newInstance(true).show(getSupportFragmentManager(), "dialog");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.accept_social_case:
                if(this.socialCaseService.getCurrentSocialCase(loggedVolunteer)!=null){
                    new AlertDialog.Builder(this)
                            .setTitle( "Caz curent existent")
                            .setMessage("Deja ai un caz curent asignat. Pentru a accepta alt caz trebuie sa renunti la cazul curent.")
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setPositiveButton("Caz curent", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    Intent intent = new Intent(mContext, MapActivity.class);
                                    intent.putExtra("currentCase",(Serializable) socialCaseService.getCurrentSocialCase(loggedVolunteer));
                                    intent.putExtra("showButtons", (Serializable) false);
                                    startActivity(intent);
                                    Toast.makeText(getApplicationContext(),"Current Case",Toast.LENGTH_SHORT).show();
                                }})
                            .setNegativeButton("Dismiss", null).show();
                }else {
                    acceptCase();
                }
                break;
            case R.id.reject_social_case:
                Toast.makeText(getApplicationContext(),"Reject",Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.drop_social_case:
                new AlertDialog.Builder(this)
                        .setTitle( help.getSocialCase().getName())
                        .setMessage("Do you really want to drop it?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                dropCase();
                            }})
                        .setNegativeButton(android.R.string.no, null).show();
                break;
            case R.id.description_social_case_icon:
                new AlertDialog.Builder(this)
                        .setTitle( "Description" )
                        .setMessage(this.help.getType() + ", " + this.help.getDescription())
                        .setIcon(android.R.drawable.ic_dialog_email)
                        .setPositiveButton(android.R.string.yes,null)
                        .show();
                break;
            case R.id.case_done:
                completeCase();
                break;
            case R.id.confirm_presence_social_case:
                confirmPresence();
                break;
            case R.id.program_in_advance_social_case:
                programInAdvance();
                break;
        }
    }

    private void acceptCase(){
        this.socialCaseService.setCurrentCase(this.help, loggedVolunteer);
        this.historyService.logActivity(new History(loggedVolunteer.getEmail(), this.help.getSocialCase().getName(), Calendar.getInstance().getTime(), "Accepted case"));
        Toast.makeText(getApplicationContext(), "Accept", Toast.LENGTH_SHORT).show();
        finish();
    }

    private void dropCase(){
        Toast.makeText(getApplicationContext(),"Drop this case",Toast.LENGTH_SHORT).show();
        this.historyService.logActivity(new History(loggedVolunteer.getEmail(), this.help.getSocialCase().getName(), Calendar.getInstance().getTime(), "Dropped case"));
        socialCaseService.deleteCurrentCase(help);
        finish();
    }

    private void completeCase() {
        Toast.makeText(getApplicationContext(),"Case done",Toast.LENGTH_SHORT).show();
        this.historyService.logActivity(new History(loggedVolunteer.getEmail(), this.help.getSocialCase().getName(), Calendar.getInstance().getTime(), "Case done"));
        socialCaseService.currentCaseDone(loggedVolunteer);
        finish();
    }

    private void confirmPresence(){
        displayLoadingDialog();
    }

    private void programInAdvance(){

         Intent intent = new Intent(this, ProgramInAvansActivity.class);
         intent.putExtra("currentCase",(Serializable) help);
         startActivity(intent);
         finish();

    }

    private void displayLoadingDialog(){
        final ProgressDialog dialog = ProgressDialog.show(this, "", "Detecting bracelet",
                true);
        dialog.show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                dialog.dismiss();
                Random random = new Random();
                if(random.nextInt(2) % 2 == 0){
                    historyService.logActivity(new History(loggedVolunteer.getEmail(), help.getSocialCase().getName(), Calendar.getInstance().getTime(), "Presence confirmed"));
                    socialCaseService.confirmPresence(loggedVolunteer);
                    Toast.makeText(getApplicationContext(),"Presence confirmed",Toast.LENGTH_SHORT).show();
                    help.setPresenceConfirmed(true);
                    onStart();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Unable to connect with wristband",Toast.LENGTH_SHORT).show();
                }
            }
        }, 2000); // 3000 milliseconds delay
    }
}


