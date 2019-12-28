package com.piu.socialcase.service;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.piu.socialcase.model.Test;
import com.piu.socialcase.repository.TestsRepository;
import com.piu.socialcase.repository.TestsRepositoryMock;

import java.util.List;

public class TestsService {


    private TestsRepository testsRepository;
    private static TestsService instance=null;

    @RequiresApi(api = Build.VERSION_CODES.O)
    private TestsService(){
        this.testsRepository=new TestsRepositoryMock();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static TestsService TestService(){
        if(instance==null)
            instance=new TestsService();

        return instance;
    }


    public List<Test> getAllAvailableTests(){
        return testsRepository.getAllAvailableTests();
    }

    public List<Test> getAllTakenTests(){
        return testsRepository.getAllTakenTests();
    }

    public void setTestTaken(Test test,int correctAnswers){
        testsRepository.setTestTaken(test,correctAnswers);
    }
}
