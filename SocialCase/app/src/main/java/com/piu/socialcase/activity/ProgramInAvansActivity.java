package com.piu.socialcase.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.piu.socialcase.R;
import com.piu.socialcase.authentication.Session;
import com.piu.socialcase.model.Help;
import com.piu.socialcase.model.TypeHelp;
import com.piu.socialcase.model.Volunteer;
import com.piu.socialcase.repository.SocialCaseRepository;
import com.piu.socialcase.repository.SocialCaseRepositoryMock;

import org.w3c.dom.Text;

import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ProgramInAvansActivity extends AppCompatActivity {

    private Volunteer volunteer;
    private SocialCaseRepository socialCaseRepository;
    private Intent intent;
    private Calendar calendar=Calendar.getInstance();
    private TextView date;
    private TextView timeView;
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
        this.timeView=(TextView) findViewById(R.id.timeProgram);
        this.help = (Help)intent.getSerializableExtra("currentCase");
        initializeViews();
        createCalendar();
        createTime();
        setButtonListener();

    }

    private void setButtonListener() {

        Button program= (Button) findViewById(R.id.butonProgram);

        program.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!checkDates()) {
                    showError();
                }else {
                    Help helpnew= new Help(help.getSocialCase(),new Date(calendar.getTimeInMillis()), TypeHelp.HELP, ((TextView) findViewById(R.id.description_text)).getText().toString());
                    socialCaseRepository.addHelp(helpnew);
                    System.out.println(helpnew.getDate().toString());
                    goToProfile(helpnew);
                }
            }
        });
    }

    private void showError(){
        new MaterialAlertDialogBuilder(this,R.style.dialogThemeError).setTitle("Error").setMessage("Please select a date and time and write a description!").setPositiveButton("Ok",null).show();

    }

    private void goToProfile(Help help){
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);
        MaterialAlertDialogBuilder dialogBuilder= new MaterialAlertDialogBuilder(this,R.style.dialogThemeSuccess).setTitle("SUCCESS").setMessage("Programarea pentru " + help.getSocialCase().getName()
        +" pentru data de " + sdf.format(help.getDate().getTime()) + " efectuata cu success");
        dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                activityProfile();
            }
        });
        dialogBuilder.show();
    }

    public void activityProfile(){
        Intent intent= new Intent(this,HomePageActivity.class);
        startActivity(intent);
    }
    private boolean checkDates(){
        if(timeView.getText().toString().matches(""))
            return false;
        TextView description= (TextView) findViewById(R.id.description_text);
        if(description.getText().toString().matches(""))
            return false;
        return !date.getText().toString().matches("");
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

    private void createTime(){
        final TimePickerDialog.OnTimeSetListener dialogTim= new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                calendar.set(Calendar.HOUR_OF_DAY,i);
                calendar.set(Calendar.MINUTE,i1);
                updateTimeLabel();
            }
        };

        this.timeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog dialogT = new TimePickerDialog(ProgramInAvansActivity.this,dialogTim,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),true);
                dialogT.show();
            }
        });
    }

    private void updateTimeLabel(){
        DecimalFormat decimalFormat= new DecimalFormat();
        decimalFormat.setMinimumIntegerDigits(2);

        this.timeView.setText(decimalFormat.format(calendar.get(Calendar.HOUR_OF_DAY)) + ":" + decimalFormat.format(calendar.get(Calendar.MINUTE)));
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
