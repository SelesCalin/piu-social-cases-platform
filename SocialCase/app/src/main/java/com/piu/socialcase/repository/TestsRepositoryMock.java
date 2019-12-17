package com.piu.socialcase.repository;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.piu.socialcase.model.Answer;
import com.piu.socialcase.model.Question;
import com.piu.socialcase.model.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestsRepositoryMock implements TestsRepository {

    List<Test> tests;
    List<Question> questions;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public TestsRepositoryMock(){
        generateMockQuestions();
        generateMockTests();
    }

    private void generateMockQuestions() {
        this.questions=new ArrayList<>();
        List<Answer> raspunsuri=new ArrayList<>();

        raspunsuri.add(new Answer("Da",false));raspunsuri.add(new Answer("Nu",true));raspunsuri.add(new Answer("Nu stiu '\' Nu raspund", false));
        this.questions.add(new Question("Esti o persoana conflictuala?", raspunsuri));
        List<Answer> raspunsuri1= new ArrayList<>();
        raspunsuri1.add(new Answer("Da",true));raspunsuri1.add(new Answer("Nu",false));raspunsuri1.add(new Answer("Nu stiu '\' Nu raspund", false));
        this.questions.add(new Question("Iti place sa iti ajuti aproapele?",raspunsuri1));
        this.questions.add(new Question("Ai mai facut voluntariat?",raspunsuri1));

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void generateMockTests() {

        this.tests=new ArrayList<>();
        tests.add(new Test(1,false,this.questions,10, LocalDateTime.now().plusDays(5),null,0));
        tests.add(new Test(2,false,this.questions,10, LocalDateTime.now().plusDays(5),null,0));
        tests.add(new Test(3,false,this.questions,10, LocalDateTime.now().plusDays(5),null,0));
        tests.add(new Test(4,true,this.questions,10, LocalDateTime.now().plusDays(5),LocalDateTime.now(),2));

    }

    @Override
    public List<Test> getAllAvailableTests() {
        List<Test> tests=new ArrayList<>();
        for(Test test: this.tests) {
            if (!test.getTaken())
                tests.add(test);
        }

        return tests;

    }

    @Override
    public List<Test> getAllTakenTests() {
        List<Test> tests=new ArrayList<>();
        for(Test test: this.tests) {
            if (test.getTaken())
                tests.add(test);
        }

        return tests;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void setTestTaken(Test test,int correctAnswers) {
        for (Test t: tests) {
            if (t.getTestNo() == test.getTestNo()) {
                t.setTaken(true);
                t.setDayTaken(LocalDateTime.now());
                t.setCorrectAnswers(correctAnswers);
            }
        }
    }
}
