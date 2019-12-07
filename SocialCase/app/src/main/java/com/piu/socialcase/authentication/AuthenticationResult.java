package com.piu.socialcase.authentication;

import com.piu.socialcase.model.Volunteer;

import java.util.ArrayList;
import java.util.List;

public class AuthenticationResult {

    private Volunteer volunteer;
    private List<String> authenticationErrors;

    public AuthenticationResult(){
        authenticationErrors = new ArrayList<>();
    }

    public void setResult(Volunteer volunteer){
        this.volunteer = volunteer;
    }

    public void addError(String newError){
        authenticationErrors.add(newError);
    }

    public boolean hasError(){
        return authenticationErrors.size() > 0;
    }

    public Volunteer getResult(){
        return volunteer;
    }
}
