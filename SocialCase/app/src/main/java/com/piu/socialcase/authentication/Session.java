package com.piu.socialcase.authentication;

import com.piu.socialcase.model.Volunteer;

public class Session {


    private static Session instance=null;

    private Volunteer loggedInUser=null;

    private Session(){
    }

    public static Session getInstance(){
        if(instance==null)
            instance=new Session();

        return instance;
    }


    public Volunteer getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(Volunteer loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
}
