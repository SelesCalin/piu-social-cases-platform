package com.piu.socialcase.fragment.homepage;


import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
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
import com.piu.socialcase.model.Help;
import com.piu.socialcase.model.SocialCase;
import com.piu.socialcase.model.TypeHelp;
import com.piu.socialcase.model.Volunteer;
import com.piu.socialcase.authentication.Session;
import com.piu.socialcase.service.SocialCaseService;

import java.util.Date;

public class AskForHelpFragment extends Fragment implements View.OnClickListener{

    private Volunteer volunteer=null;
    private SocialCase socialCase;
    private SocialCaseService socialCaseService;

    private TextView nameTextView;
    private TextInputLayout socialCaseTextView;
    private TextInputLayout descriptionTextView;
    private NumberPicker numberOfPersonsNumberPicker;
    private CheckBox emergencyCheckBox;
    private Button sendButton;


    public AskForHelpFragment() {
        // Required empty public constructor
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        volunteer = Session.getInstance().getLoggedInUser();
        this.socialCaseService = SocialCaseService.SocialCaseService();
        Help help = this.socialCaseService.getCurrentSocialCase(volunteer);
        if(help!=null) {
            socialCase = help.getSocialCase();
        }
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
        if(socialCase!=null) {
            socialCaseTextView.getEditText().setText(socialCase.getName());
            socialCaseTextView.getEditText().setEnabled(false);
        }
    }

    NumberPicker.OnValueChangeListener onValueChangeListener =
            new 	NumberPicker.OnValueChangeListener(){
                @Override
                public void onValueChange(NumberPicker numberPicker, int i, int i1) {
//                    Toast.makeText(getApplicationContext(),
//                            "selected number "+numberPicker.getValue(), Toast.LENGTH_SHORT);
                }
            };



    private Help newHelp(){
        String description="";
        if(emergencyCheckBox.isActivated()) {
            description = "Este nevoie de  " + numberOfPersonsNumberPicker.getValue() + " persoane, fiind o URGENTA, " + descriptionTextView.getEditText().getText();
        }
        else
        {
            description = "Este nevoie de  " + numberOfPersonsNumberPicker.getValue() + " persoane, " + descriptionTextView.getEditText().getText();
        }
        Help help = new Help(socialCase, new Date(),
                TypeHelp.ASKFORHELP, description);
        return help;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.butonSend_ask:
                if(socialCase!=null) {
                    this.socialCaseService.addHelp(newHelp());
                    Toast.makeText(getActivity().getApplicationContext(), "Asked for help", Toast.LENGTH_SHORT).show();
                    BottomNavigationView bottomNavigationView;
                    bottomNavigationView = (BottomNavigationView) getActivity().findViewById(R.id.bottom_navigation);
                    bottomNavigationView.getMenu().findItem(R.id.home_page_button).setChecked(true);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProfileFragment()).commit();
                    break;
                }
                else{
                    Toast.makeText(getActivity().getApplicationContext(), "Caz curent inexistent", Toast.LENGTH_SHORT).show();
                }
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
        boolean descriptionTextViewCorrect=TextUtils.isEmpty(descriptionTextView.getError()) && descriptionTextView.getEditText().getText().length()>0;
        if(socialCaseTextViewCorrect && descriptionTextViewCorrect ) {
            sendButton.setEnabled(true);
        }else {
            sendButton.setEnabled(false);
        }
    }

}
