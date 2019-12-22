package com.piu.socialcase.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.piu.socialcase.R;
import com.piu.socialcase.model.History;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;


public class HistoryAdapter extends ArrayAdapter<History> {

    private static final String dateFormatPattern = "HH:mm dd/MM/yyyy";
    private static final DateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);

    private List<History> historyList;

    public HistoryAdapter(Context context, List<History> historyList) {
        super(context, 0, historyList);
        this.historyList = historyList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = (convertView == null) ?
                inflater.inflate(R.layout.history_item, parent, false) : convertView;

        History history = historyList. get(position);

        TextView socialCaseNameTextView = row.findViewById(R.id.history_item_social_case_name);
        socialCaseNameTextView.setText(history.getSocialCaseName());

        TextView dateTextView = row.findViewById(R.id.history_item_date);
        dateTextView.setText(dateFormat.format(history.getDate()));

        TextView descriptionTextView = row.findViewById(R.id.history_item_description);
        descriptionTextView.setText(history.getDescription());

        return row;
    }
}
