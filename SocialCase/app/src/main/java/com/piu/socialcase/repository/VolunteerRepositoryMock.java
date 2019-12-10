package com.piu.socialcase.repository;

import com.piu.socialcase.model.Volunteer;

import java.util.ArrayList;
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
        ArrayList<Volunteer> list = new ArrayList<>();
        Volunteer v1 = new Volunteer("Calin Calin-Florin", "calin", "calin@gmail.com", "0712345678", "ONG");
        Volunteer v2 = new Volunteer("user", "user", "user@user.com", "07456789123", "ONG2");
        list.add(v1);list.add(v2);
        return list;
    }


    public void addVolunteer(Volunteer volunteer){
        volunteers.add(volunteer);
    }

    @Override
    public Volunteer findVolunteerByEmail(String email) {
        for(Volunteer volunteer: volunteers)
            if(volunteer.getEmail().equals(email))
                return volunteer;
        return null;
    }
}
