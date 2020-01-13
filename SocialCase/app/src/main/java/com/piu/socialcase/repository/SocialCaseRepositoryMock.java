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
    List<Help> helpListWaiting;
    List<SocialCase> socialCaseList;
    private static SocialCaseRepository instance;
    private VolunteerRepository volunteerRepository;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static SocialCaseRepository getInstance(){
        if(instance==null) {
            instance = new SocialCaseRepositoryMock();
        }
        return instance;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private SocialCaseRepositoryMock(){
        this.volunteerRepository = VolunteerRepositoryMock.getInstance();
        socialCaseList = generateMockSocialCases();
        helpList = generateMockHelp();
        helpListWaiting = new ArrayList<>();
    }

    private List<SocialCase> generateMockSocialCases() {

        ArrayList<SocialCase> list = new ArrayList<>();
        SocialCase sc1 = new SocialCase("Stanescu Andrei", "0756573200",
                getDate("1952.07.06"),"Str. Observatorului, nr. 1",46.770439, 23.591423);
        SocialCase sc2 = new SocialCase("Botis Andreea", "0727888018",
                getDate("1949.07.09"),"Str. Lunii, nr.55, bl.5, ap.135 ",46.752424, 23.583804);
        SocialCase sc3 = new SocialCase("Simon Ion", "0756573200",
                getDate("1952.07.06"),"Observatorului, nr. 1",46.755006, 23.594583);
        SocialCase sc4 = new SocialCase("Grad Amalia", "0756537071",
                getDate("1958.03.15"),"Str. Bucegi, nr. 112",46.782400, 23.601476);
        SocialCase sc5 = new SocialCase("Popescu Diana", "0756537071",
                getDate("1958.03.15"),"Str. Bucegi, nr. 112",46.767146, 23.611593);
        list.add(sc1);list.add(sc2);list.add(sc3);list.add(sc4);list.add(sc5);
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
        Help h1 = new Help(getSocialCaseByName("Simon Ion"), getDate("2020.12.31"),
                TypeHelp.HELP,"ajutor");
        h1.setVolunteer(volunteerRepository.findVolunteerByUsername("user"));
        Help h2 = new Help(getSocialCaseByName("Stanescu Andrei"), getDate("2020.12.31"),
                TypeHelp.SOS,"ajutor imediat");
//        h2.setVolunteer(volunteerRepository.findVolunteerByUsername("admin"));
        Help h3 = new Help(getSocialCaseByName("Grad Amalia"), getDate("2020.11.31"),
                TypeHelp.BATTERY,"bratara descarcata");
        Help h5 = new Help(getSocialCaseByName("Popescu Diana"), getDate("2020.01.14"),
                TypeHelp.MEDICATION,"\n"+"Marti:  08:00-10:00 -> Nurofen" + "\n\t\t\t\t\t\t" + "18:00-20:00 -> Vitamina D, Picaturi in ochi");


        list.add(h1);
        list.add(h2);
        list.add(h3);
        list.add(h5);
        return list;
    }

    public void isAskForHelp(Boolean b){
        Help h4 = new Help(getSocialCaseByName("Botis Andreea"), getDate("2020.10.31"),
                TypeHelp.SOS,"ajutor imediat");

        Help h6 = new Help(getSocialCaseByName("Botis Andreea"), getDate("2020.10.31"),
                TypeHelp.ASKFORHELP,"Am nevoie de ajutor.");
        if(b) {
            helpListWaiting.add(h6);
        }else{
            helpList.add(h4);
        }
    }

    public Help getHelpByName(String name){
        Help returnHelp =null;
        for(Help h : helpList) {
            if (h.getSocialCase().getName().equals(name)) {
                returnHelp= h;
            }
        }

        return returnHelp;
    }

    public Help getHelpByNameWaiting(String name){
        Help returnHelp =null;
        for(Help h : helpListWaiting) {
            if (h.getSocialCase().getName().equals(name)) {
                returnHelp= h;
            }
        }

        return returnHelp;
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
    public List<Help> getAllUnassignedHelp() {

        List<Help> unassignedHelp = new ArrayList<>();
        for(Help help: helpList){
            if(help.getVolunteer() == null){
                unassignedHelp.add(help);
            }
        }
        return unassignedHelp;
    }

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

    @Override
    public void addHelpAsk(Help help) {
        this.helpListWaiting.add(help);
    }


    @Override
    public void addHelpWaiting() {
        for(Help help: helpListWaiting) {
            this.helpList.add(help);
        }
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

    @Override
    public void currentCaseDone(Volunteer volunteer) {
        for(Help help: helpList) {
            if(help.getVolunteer() == null)
                continue;

            if (help.getVolunteer().getUsername().equals(volunteer.getUsername())){
                helpList.remove(help);
                return;
            }
        }
    }

    @Override
    public void confirmPresence(Volunteer volunteer) {
        for(Help help: helpList) {
            if(help.getVolunteer() == null)
                continue;

            if (help.getVolunteer().getUsername().equals(volunteer.getUsername())){
                help.setPresenceConfirmed(true);
                return;
            }
        }
    }
}
