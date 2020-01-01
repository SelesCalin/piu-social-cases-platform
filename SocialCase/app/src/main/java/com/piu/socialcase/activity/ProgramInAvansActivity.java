package com.piu.socialcase.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.piu.socialcase.R;
import com.piu.socialcase.authentication.Session;
import com.piu.socialcase.model.Help;
import com.piu.socialcase.model.Volunteer;
import com.piu.socialcase.repository.SocialCaseRepository;
import com.piu.socialcase.repository.SocialCaseRepositoryMock;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ProgramInAvansActivity extends AppCompatActivity {

    private Volunteer volunteer;
    private SocialCaseRepository socialCaseRepository;
    private Intent intent;
    private Calendar calendar=Calendar.getInstance();
    private TextView date;
    private Help help;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_in_avans);
        this.socialCaseRepository= SocialCaseRepositoryMock.getInstance();
        Intent intent=getIntent();
       Session session=Session.getInstance();
        this.volunteer=session.getLoggedInUser();
        this.date=(TextView) findViewById(R.id.date);
        this.help = (Help)intent.getSerializableExtra("currentCase");
        initializeViews();
        createCalendar();

    }

    private void createCalendar() {
        final DatePickerDialog.OnDateSetListener datedialog= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(Calendar.YEAR,i);
                calendar.set(Calendar.MONTH,i1);
                calendar.set(Calendar.DAY_OF_MONTH,i2);
                updateLabels();
            }
        };

       this.date.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                DatePickerDialog dialog= new  DatePickerDialog(ProgramInAvansActivity.this,datedialog,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
                dialog.getDatePicker().setMinDate(System.currentTimeMillis());
                dialog.show();
            }
        });
    }

    private void updateLabels() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);
        this.date.setText(sdf.format(calendar.getTime()));
    }

    private void initializeViews() {
        TextView voluntar=(TextView) findViewById(R.id.voluntar);
        voluntar.append(volunteer.getUsername());
        TextView cazzz= (TextView) findViewById(R.id.currentCase);
        cazzz.append(help.getSocialCase().getName());


    }
}
