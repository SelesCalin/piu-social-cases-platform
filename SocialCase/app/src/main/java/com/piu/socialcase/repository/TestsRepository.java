package com.piu.socialcase.repository;

import com.piu.socialcase.model.Test;

import java.util.List;

public interface TestsRepository {



    List<Test> getAllAvailableTests();

    List<Test> getAllTakenTests();

    void setTestTaken(Test test,int correctAnswers);
}
