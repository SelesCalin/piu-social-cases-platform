package com.piu.socialcase.repository;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.android.gms.maps.model.LatLng;
import com.piu.socialcase.model.Help;
import com.piu.socialcase.model.Question;
import com.piu.socialcase.model.SocialCase;
import com.piu.socialcase.model.Test;
import com.piu.socialcase.model.TypeHelp;
import com.piu.socialcase.model.Volunteer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SocialCaseRepositoryMock implements SocialCaseRepository {

    List<Help> helpList;
    List<SocialCase> socialCaseList;

    private VolunteerRepository volunteerRepository;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public SocialCaseRepositoryMock(){
        this.volunteerRepository = new VolunteerRepositoryMock();
        socialCaseList = generateMockSocialCases();
        helpList = generateMockHelp();
    }

    private List<SocialCase> generateMockSocialCases() {

        ArrayList<SocialCase> list = new ArrayList<>();
        SocialCase sc1 = new SocialCase("Andrei Munten", "0712345678",
                getDate("1966.05.06"),"Observator, Cluj",46.770439, 23.591423);
        SocialCase sc2 = new SocialCase("Maria Lazar", "0712348568",
                getDate("1958.01.15"),"Observator, Cluj",46.753855, 23.579275);
        list.add(sc1);list.add(sc2);
        return list;
    }

    private Date getDate(String date){
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd");
        Date t = new Date();
        try {
            t = ft.parse(date);
        } catch (ParseException e) {
            System.out.println("Unparseable using " + ft);
        }
        return t;
    }

    private List<Help> generateMockHelp() {
        ArrayList<Help> list = new ArrayList<>();
        Help h1 = new Help(getSocialCaseByName("Maria Lazar"), getDate("2019.12.29"),
                TypeHelp.HELP,"ajutor");
        h1.setVolunteer(volunteerRepository.findVolunteerByUsername("user"));
        Help h2 = new Help(getSocialCaseByName("Andrei Munten"), getDate("2019.12.31"),
                TypeHelp.SOS,"ajutor imediat");
        //h2.setVolunteer(volunteerRepository.findVolunteerByUsername("admin"));
        list.add(h1);list.add(h2);
        return list;
    }

    @Override
    public Help getCurrentCaseVolunteer(Volunteer volunteer) {
        for(Help help: helpList) {
            if(help.getVolunteer()!=null) {
                if (help.getVolunteer().getUsername().equals(volunteer.getUsername()))
                    return help;
            }
        }
        return null;
    }

    @Override
    public List<SocialCase> getAllSocialCases() {
        return socialCaseList;
    }

    @Override
    public SocialCase getSocialCaseByName(String name) {
        for(SocialCase socialCase: socialCaseList) {
            if (socialCase.getName().equals(name))
                return socialCase;
        }
        return null;
    }

    @Override
    public Help getHelpBySocialCase(SocialCase socialCase) {
        for(Help help: helpList) {
            if (help.getSocialCase().getName().equals(socialCase.getName()))
                return help;
        }
        return null;
    }

    @Override
    public void setCurrentCaseVolunteer(SocialCase socialCase, Volunteer volunteer) {
        for(Help help: helpList) {
            if (help.getSocialCase().getName().equals(socialCase.getName())){
                help.setVolunteer(volunteer);
            }
        }
    }
}
