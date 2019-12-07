package com.piu.socialcase.service;

import com.piu.socialcase.authentication.AuthenticationResult;
import com.piu.socialcase.model.Volunteer;
import com.piu.socialcase.repository.VolunteerRepository;
import com.piu.socialcase.repository.VolunteerRepositoryMock;

public class LoginService {

    private static final String USER_NOT_FOUND_ERROR = "User not found or wrong password";
    private static final String USERNAME_TOO_SHORT_ERROR = "Username too short";
    private static final String PASSWORD_TOO_SHORT_ERROR = "Password too short";

    private VolunteerRepository volunteerRepository;

    public LoginService(VolunteerRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
    }

    public LoginService(){
        this.volunteerRepository = new VolunteerRepositoryMock();
    }

    public AuthenticationResult login(String username, String password){

        AuthenticationResult authenticationResult = new AuthenticationResult();
        if(username.length() < 2)
            authenticationResult.addError(USERNAME_TOO_SHORT_ERROR);
        if(password.length() < 2)
            authenticationResult.addError(PASSWORD_TOO_SHORT_ERROR);

        if(authenticationResult.hasError())
            return authenticationResult;

        Volunteer volunteer = volunteerRepository.findVolunteerByUsername(username);
        if(volunteer == null){
            authenticationResult.addError(USER_NOT_FOUND_ERROR);
            return authenticationResult;
        }

        if(!volunteer.getPassword().equals(password)){
            authenticationResult.addError(USER_NOT_FOUND_ERROR);
            return authenticationResult;
        }

        volunteer.setPassword("");
        authenticationResult.setResult(volunteer);
        return authenticationResult;
    }
}
