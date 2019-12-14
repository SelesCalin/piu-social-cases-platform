package com.piu.socialcase.fragment.homepage;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.piu.socialcase.R;
import com.piu.socialcase.model.Volunteer;
import com.piu.socialcase.authentication.Session;

public class AskForHelpFragment extends Fragment {

    private Volunteer volunteer=null;

    private TextView nameTextView;
    private TextInputLayout socialCaseTextView;
    private TextInputLayout locationTextView;
    private TextInputLayout descriptionTextView;
    private NumberPicker numberOfPersonsNumberPicker;
    private CheckBox emergencyCheckBox;

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
        setInfo();
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
}
