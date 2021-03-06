package com.piu.socialcase.fragment.homepage;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.piu.socialcase.R;

import com.piu.socialcase.adapters.HistoryAdapter;
import com.piu.socialcase.model.History;
import com.piu.socialcase.model.Volunteer;
import com.piu.socialcase.authentication.Session;
import com.piu.socialcase.service.HistoryService;

import java.util.List;


public class HistoryFragment extends Fragment {

    private Volunteer volunteer=null;

    private List<History> historyList;

    private HistoryService historyService;

    private HistoryAdapter historyAdapter;

    private ListView historyListView;

    public HistoryFragment() {
        // Required empty public constructor
        historyService = new HistoryService();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        volunteer = Session.getInstance().getLoggedInUser();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_history, container, false);
        if(volunteer != null)
            initializeView(fragmentView);
        return fragmentView;
    }

    private void initializeView(View view) {
        historyList = historyService.getHistoryByVolunteerEmail(volunteer.getEmail());
        historyAdapter = new HistoryAdapter(getContext(),historyList);
        historyListView = view.findViewById(R.id.history_list_view);
        historyListView.setAdapter(historyAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();

        historyList.clear();
        historyList.addAll(historyService.getHistoryByVolunteerEmail(volunteer.getEmail()));
        historyAdapter.notifyDataSetChanged();
    }
}
