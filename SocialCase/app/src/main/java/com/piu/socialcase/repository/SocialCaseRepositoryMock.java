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
import java.util.Objects;
import java.util.Random;

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
                TypeHelp.HELP,"ajutor dfghjkl;ghjkl,;   fghjuikcfvghbjnm   fvgbhjnkghbjnkm  fghvbjnkmlhjkl ghjkltyuhijko did");
        h1.setVolunteer(volunteerRepository.findVolunteerByUsername("user"));
        Help h2 = new Help(getSocialCaseByName("Andrei Munten"), getDate("2019.12.31"),
                TypeHelp.SOS,"ajutor imediat");
//        h2.setVolunteer(volunteerRepository.findVolunteerByUsername("admin"));
        Help h3 = new Help(getSocialCaseByName("Andrei Munten"), getDate("2019.11.31"),
                TypeHelp.BATTERY,"bratara descarcata");
        Help h4 = new Help(getSocialCaseByName("Maria Lazar"), getDate("2019.10.31"),
                TypeHelp.ASKFORHELP,"volunteer ask for help");
        list.add(h1);
        list.add(h2);
        list.add(h3);
        list.add(h4);
        return list;
    }

//    private List<Help> generateMockHelpBeforeNotification() {
//        ArrayList<Help> list = new ArrayList<>();
//        Help h1 = new Help(getSocialCaseByName("Maria Lazar"), getDate("2019.12.30"),
//                TypeHelp.HELP,"ajutor");
//        Help h2 = new Help(getSocialCaseByName("Andrei Munten"), getDate("2019.12.31"),
//                TypeHelp.SOS,"ajutor imediat");
//        Help h3 = new Help(getSocialCaseByName("Andrei Munten"), getDate("2019.11.31"),
//                TypeHelp.BATTERY,"bratara descarcata");
//        Help h4 = new Help(getSocialCaseByName("Maria Lazar"), getDate("2019.10.31"),
//                TypeHelp.ASKFORHELP,"volunteer ask for help");
//        list.add(h1);
//        list.add(h2);
//        list.add(h3);
//        list.add(h4);
//        return list;
//    }

    @Override
    public Help getCurrentCaseVolunteer(Volunteer volunteer) {
        for(Help help: helpList) {
            if(help.getVolunteer()!=null && volunteer !=null) {
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
    public Help getHelp() {
        List<Help> helpListBeforeNotification = new ArrayList<>();
        for(Help help: helpList) {
            if (help.getVolunteer()==null){
                helpListBeforeNotification.add(help);
            }
        }
        Random rand = new Random();
        int min = 0;
        int max = helpListBeforeNotification.size()-1;
        int randomNum = rand.nextInt((max - min) + 1) + min;
        if(helpListBeforeNotification.get(randomNum)!=null)
            return helpListBeforeNotification.get(randomNum);
        return null;
    }

    @Override
    public void addHelp(Help help) {
        this.helpList.add(help);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void setCurrentCaseVolunteer(Help helpL, Volunteer volunteer) {
        for(Help help: helpList) {
            if (help.equals(helpL)){
                help.setVolunteer(volunteer);
            }
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void deleteCurrentCaseVolunteer(Help helpL) {
        for(Help help: helpList) {
            if (help.equals(helpL)){
                help.setVolunteer(null);
            }
        }
    }

}
