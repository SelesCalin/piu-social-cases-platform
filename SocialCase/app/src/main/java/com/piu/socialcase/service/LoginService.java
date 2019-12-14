package com.piu.socialcase.service;

import com.piu.socialcase.authentication.AuthenticationResult;
import com.piu.socialcase.model.Volunteer;
import com.piu.socialcase.repository.DataRepositoryMock;
import com.piu.socialcase.repository.VolunteerRepository;
import com.piu.socialcase.repository.VolunteerRepositoryMock;

import java.util.ArrayList;

public class LoginService {

    private static final String USER_NOT_FOUND_ERROR = "User not found or wrong password";
    private static final String USERNAME_TOO_SHORT_ERROR = "Username too short";
    private static final String PASSWORD_TOO_SHORT_ERROR = "Password too short";

    private VolunteerRepository volunteerRepository;
    private DataRepositoryMock dataRepository;

    private static LoginService instance=null;

    private LoginService(){
        this.volunteerRepository = new VolunteerRepositoryMock();
        this.dataRepository = new DataRepositoryMock();
    }

    public static LoginService LoginService(){
        if(instance==null) {
            instance = new LoginService();
        }
        return instance;
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

        authenticationResult.setResult(volunteer);
        return authenticationResult;
    }

    public Integer signUp(String username,String password, String confirmPass, String email, String phone, String address,String dateOfBirth,String[] preferences){
        if(volunteerRepository.findVolunteerByUsername(username)!=null)
            return -1;

        if(volunteerRepository.findVolunteerByEmail(email)!=null)
            return -2;

        if(!password.equals(confirmPass))
            return -3;
        Volunteer volunteer= new Volunteer(username,password,email,phone,dateOfBirth,address,null,preferences);
        volunteer.setAvailable(dataRepository.getAvailableTime());
        volunteerRepository.addVolunteer(volunteer);

        return 1;
    }
}
