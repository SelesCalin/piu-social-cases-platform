package com.piu.socialcase.fragment.homepage;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.piu.socialcase.R;
import com.piu.socialcase.model.Volunteer;
import com.piu.socialcase.authentication.Session;
import com.piu.socialcase.repository.DataRepositoryMock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ProgramFragment extends Fragment implements View.OnClickListener {

    private Volunteer volunteer=null;

    private TextView dateTextView;
    public String[] dateList;
    public ListView listView;
    public ArrayAdapter<String> dateAdapter;
    public DataRepositoryMock dataRepositoryMock;
    private Button sendButton;
    SparseBooleanArray sparseBooleanArray ;

    public ProgramFragment() {
        // Required empty public constructor
        dataRepositoryMock = new DataRepositoryMock();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        volunteer= Session.getInstance().getLoggedInUser();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_program, container, false);
        if(volunteer != null)
            initializeViews(fragmentView);
        return fragmentView;
    }

    private void initializeViews(View view) {
        dateTextView = view.findViewById(R.id.date);
        listView = view.findViewById(R.id.listView);
        dateList = dataRepositoryMock.getDates();
        dateAdapter = new ArrayAdapter<String>
                (getActivity(),
                        android.R.layout.simple_list_item_multiple_choice,
                        android.R.id.text1, dateList );
        listView.setAdapter(dateAdapter);
        sendButton = view.findViewById(R.id.butonSend_program);
        sendButton.setOnClickListener(this);
        setInfo();
    }

    private void setInfo() {
        Calendar calendar = Calendar.getInstance();
        String currentDateTimeString = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        dateTextView.setText(currentDateTimeString);
        for (int i = 0; i < dateList.length; i++) {
            if (volunteer.getAvailable()!=null) {
                if (volunteer.getAvailable().get(dateList[i])) {
                    listView.setItemChecked(i, true);
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.butonSend_program:
                sparseBooleanArray = listView.getCheckedItemPositions();
                int i = 0 ;
                while (i < sparseBooleanArray.size()) {
                    if (sparseBooleanArray.valueAt(i)) {
                        volunteer.getAvailable().put(dateList[sparseBooleanArray.keyAt(i)],true);
                    }
                    i++ ;
                }
                Toast.makeText(getActivity().getApplicationContext(),"Saved Schedule",Toast.LENGTH_SHORT).show();
                BottomNavigationView bottomNavigationView;
                bottomNavigationView = (BottomNavigationView) getActivity().findViewById(R.id.bottom_navigation);
                bottomNavigationView.getMenu().findItem(R.id.home_page_button).setChecked(true);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ProfileFragment()).commit();
                break;
        }
    }
}
