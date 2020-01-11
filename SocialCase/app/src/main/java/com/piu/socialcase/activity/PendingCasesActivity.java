package com.piu.socialcase.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.piu.socialcase.R;
import com.piu.socialcase.adapters.HelpAdapter;
import com.piu.socialcase.model.Help;
import com.piu.socialcase.model.History;
import com.piu.socialcase.service.HistoryService;
import com.piu.socialcase.service.SocialCaseService;

import java.util.List;

public class PendingCasesActivity extends AppCompatActivity {

    private List<Help> helpList;
    private SocialCaseService socialCaseService;
    private HelpAdapter helpAdapter;

    private ListView helpListView;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_cases);

        socialCaseService = SocialCaseService.SocialCaseService();
        helpList = socialCaseService.getUnassignedHelp();

        helpListView = findViewById(R.id.pending_cases_list_view);
        helpAdapter = new HelpAdapter(this, helpList);
        helpListView.setAdapter(helpAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        helpList.clear();
        helpList.addAll(socialCaseService.getUnassignedHelp());
        helpAdapter.notifyDataSetChanged();
    }
}
