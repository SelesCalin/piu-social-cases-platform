package com.piu.socialcase.repository;

import com.piu.socialcase.model.Volunteer;

import java.util.Arrays;
import java.util.List;

public class VolunteerRepositoryMock implements  VolunteerRepository {

    private List<Volunteer> volunteers;

    public VolunteerRepositoryMock(){
        volunteers = generateVolunteers();
    }

    public Volunteer findVolunteerByUsername(final String username){
        for(Volunteer volunteer: volunteers)
            if(volunteer.getUsername().equals(username))
                return volunteer;

        return null;
    }

    private List<Volunteer> generateVolunteers(){
        Volunteer v1 = new Volunteer("Calin Calin-Florin", "calin", "calin@gmail.com", "0712345678", "ONG");
        Volunteer v2 = new Volunteer("user", "user", "user@user.com", "07456789123", "ONG2");
        return Arrays.asList(v1, v2);
    }
}
