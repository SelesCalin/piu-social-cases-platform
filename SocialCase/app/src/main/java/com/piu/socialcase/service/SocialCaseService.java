package com.piu.socialcase.service;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.piu.socialcase.model.Help;
import com.piu.socialcase.model.SocialCase;
import com.piu.socialcase.model.Test;
import com.piu.socialcase.model.Volunteer;
import com.piu.socialcase.repository.SocialCaseRepository;
import com.piu.socialcase.repository.SocialCaseRepositoryMock;
import com.piu.socialcase.repository.TestsRepository;
import com.piu.socialcase.repository.TestsRepositoryMock;

import java.util.List;

public class SocialCaseService {

    private SocialCaseRepository socialCaseRepository;
    private static SocialCaseService instance=null;

    @RequiresApi(api = Build.VERSION_CODES.O)
    private SocialCaseService(){
        this.socialCaseRepository=new SocialCaseRepositoryMock();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static SocialCaseService SocialCaseService(){
        if(instance==null)
            instance=new SocialCaseService();

        return instance;
    }

    public List<SocialCase> getAllSocialCases(){
        return socialCaseRepository.getAllSocialCases();
    }

    public Help getCurrentSocialCase(Volunteer volunteer){
        return socialCaseRepository.getCurrentCaseVolunteer(volunteer);
    }

    public Help getHelp(){
        return socialCaseRepository.getHelp();
    }

    public void setCurrentCase(Help help, Volunteer volunteer){
        socialCaseRepository.setCurrentCaseVolunteer(help,volunteer);
    }

    public void deleteCurrentCase(Help help){
        socialCaseRepository.deleteCurrentCaseVolunteer(help);
    }

    public void addHelp(Help help){
        socialCaseRepository.addHelp(help);
    }

}
