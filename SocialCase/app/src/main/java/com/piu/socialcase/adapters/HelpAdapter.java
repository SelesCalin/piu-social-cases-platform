package com.piu.socialcase.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.piu.socialcase.R;
import com.piu.socialcase.activity.MapActivity;
import com.piu.socialcase.model.Help;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class HelpAdapter extends ArrayAdapter<Help> {

    private static final String dateFormatPattern = "HH:mm dd/MM/yyyy";
    private static final DateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);

    private List<Help> helpList;

    public HelpAdapter(Context context, List<Help> helpList){
        super(context, 0, helpList);
        this.helpList = helpList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = (convertView == null) ?
                inflater.inflate(R.layout.pending_case_item, parent, false) : convertView;

        final Help help = helpList. get(position);

        TextView socialCaseNameTextView = row.findViewById(R.id.pending_case_item_social_case_name);
        socialCaseNameTextView.setText(help.getSocialCase().getName());

        TextView typeHelpTextView = row.findViewById(R.id.pending_case_item_type_help);
        typeHelpTextView.setText(help.getType() + ", " + help.getDescription());

        TextView dateTextView = row.findViewById(R.id.pending_case_item_date);
        dateTextView.setText(dateFormat.format(help.getDate()));

        Button detailsButton = row.findViewById(R.id.pending_case_item_case_details_button);
        detailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MapActivity.class);
                intent.putExtra("currentCase",(Serializable) help);
                intent.putExtra("showButtons", (Serializable) true);
                getContext().startActivity(intent);
            }
        });

        return row;
    }
}
