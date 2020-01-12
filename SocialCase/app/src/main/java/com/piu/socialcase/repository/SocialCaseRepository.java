package com.piu.socialcase.repository;

import com.piu.socialcase.model.Help;
import com.piu.socialcase.model.History;
import com.piu.socialcase.model.SocialCase;
import com.piu.socialcase.model.Volunteer;

import java.util.List;

public interface SocialCaseRepository {

    List<Help> getAllUnassignedHelp();
    Help getCurrentCaseVolunteer(Volunteer volunteer);
    Help getHelpBySocialCase(SocialCase socialCase);
    Help getHelp();
    void addHelp(Help help);
    void addHelpAsk(Help help);
    public void addHelpWaiting();
    void setCurrentCaseVolunteer(Help helpL,Volunteer volunteer);
    void deleteCurrentCaseVolunteer(Help help);
    List<SocialCase> getAllSocialCases();
    SocialCase getSocialCaseByName(String name);
    void currentCaseDone(Volunteer volunteer);
    void confirmPresence(Volunteer volunteer);
    Help getHelpByName(String name);
}
