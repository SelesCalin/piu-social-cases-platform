package com.piu.socialcase.repository;

import com.piu.socialcase.model.Help;
import com.piu.socialcase.model.History;
import com.piu.socialcase.model.SocialCase;
import com.piu.socialcase.model.Volunteer;

import java.util.List;

public interface SocialCaseRepository {

    Help getCurrentCaseVolunteer(Volunteer volunteer);
    Help getHelpBySocialCase(SocialCase socialCase);
    void setCurrentCaseVolunteer(SocialCase socialCase,Volunteer volunteer);
    List<SocialCase> getAllSocialCases();
    SocialCase getSocialCaseByName(String name);
}
