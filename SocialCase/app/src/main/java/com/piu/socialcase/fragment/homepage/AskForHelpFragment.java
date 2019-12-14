package com.piu.socialcase.fragment.homepage;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputLayout;
import com.piu.socialcase.R;
import com.piu.socialcase.model.Volunteer;
import com.piu.socialcase.authentication.Session;

public class AskForHelpFragment extends Fragment implements View.OnClickListener{

    private Volunteer volunteer=null;

    private TextView nameTextView;
    private TextInputLayout socialCaseTextView;
    private TextInputLayout locationTextView;
    private TextInputLayout descriptionTextView;
    private NumberPicker numberOfPersonsNumberPicker;
    private CheckBox emergencyCheckBox;
    private Button sendButton;

    public AskForHelpFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        volunteer = Session.getInstance().getLoggedInUser();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_ask_for_help, container, false);
        if(volunteer != null)
            initializeViews(fragmentView);
        return fragmentView;
    }

    private void initializeViews(View view) {
        nameTextView = view.findViewById(R.id.username_ask);
        socialCaseTextView = view.findViewById(R.id.help_for_text_input_layout_ask);
        locationTextView = view.findViewById(R.id.location_text_input_layout_ask);
        descriptionTextView = view.findViewById(R.id.description_text_input_layout_ask);
        numberOfPersonsNumberPicker = view.findViewById(R.id.numberOfPersons_ask);
        numberOfPersonsNumberPicker.setMinValue(1);
        numberOfPersonsNumberPicker.setMaxValue(10);
        numberOfPersonsNumberPicker.setOnValueChangedListener(onValueChangeListener);
        emergencyCheckBox = view.findViewById(R.id.emergency_ask);
        sendButton = view.findViewById(R.id.butonSend_ask);
        sendButton.setOnClickListener(this);
        setInfo();
        setupFloatingLabelError();
        checkFieldsForEmptyValues();
    }

    private void setInfo() {
        nameTextView.setText(volunteer.getUsername());
        nameTextView.setEnabled(false);
    }

    NumberPicker.OnValueChangeListener onValueChangeListener =
            new 	NumberPicker.OnValueChangeListener(){
                @Override
                public void onValueChange(NumberPicker numberPicker, int i, int i1) {
//                    Toast.makeText(getApplicationContext(),
//                            "selected number "+numberPicker.getValue(), Toast.LENGTH_SHORT);
                }
            };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.butonSend_ask:
                Toast.makeText(getActivity().getApplicationContext(),"Asked for help",Toast.LENGTH_SHORT).show();
                BottomNavigationView bottomNavigationView;
                bottomNavigationView = (BottomNavigationView) getActivity().findViewById(R.id.bottom_navigation);
                bottomNavigationView.getMenu().findItem(R.id.home_page_button).setChecked(true);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ProfileFragment()).commit();
                break;
        }
    }

    private void setupFloatingLabelError(){
        socialCaseTextView.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener(){

            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b) {
                    if(socialCaseTextView.getEditText().getText().length()>0 && socialCaseTextView.getEditText().getText().length()<4) {
                        socialCaseTextView.setError("Choose a social Case");
                    }else {
                        socialCaseTextView.setError(null);
                    }
                    checkFieldsForEmptyValues();
                }
            }
        });

        locationTextView.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener(){

            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b) {
                    if(locationTextView.getEditText().getText().length()>0 && locationTextView.getEditText().getText().length()<4) {
                        locationTextView.setError("Enter Location");
                    }else {
                        locationTextView.setError(null);
                    }
                    checkFieldsForEmptyValues();
                }
            }
        });

        descriptionTextView.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener(){

            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b) {
                    if(descriptionTextView.getEditText().getText().length()>0 && descriptionTextView.getEditText().getText().length()<10) {
                        descriptionTextView.setError("Description must contain at least 10 characters");
                    }else {
                        descriptionTextView.setError(null);
                    }
                    checkFieldsForEmptyValues();
                }
            }
        });
    }

    private void checkFieldsForEmptyValues(){
        boolean socialCaseTextViewCorrect=TextUtils.isEmpty(socialCaseTextView.getError()) && socialCaseTextView.getEditText().getText().length()>0;
        boolean locationTextViewCorrect=TextUtils.isEmpty(locationTextView.getError()) && locationTextView.getEditText().getText().length()>0;
        boolean descriptionTextViewCorrect=TextUtils.isEmpty(descriptionTextView.getError()) && descriptionTextView.getEditText().getText().length()>0;
        if(socialCaseTextViewCorrect && locationTextViewCorrect && descriptionTextViewCorrect ) {
            sendButton.setEnabled(true);
        }else {
            sendButton.setEnabled(false);
        }
    }

}
