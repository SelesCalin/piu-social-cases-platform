package com.piu.socialcase.repository;

import android.os.Build;

import androidx.annotation.RequiresApi;

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
        HashMap<String,Boolean> raspunsuri=new HashMap<>();
        raspunsuri.put("Da",false);raspunsuri.put("Nu",true);raspunsuri.put("Nu stiu '\' Nu raspund", false);
        this.questions.add(new Question("Esti o persoana conflictuala?", raspunsuri));
        raspunsuri.clear();
        raspunsuri.put("Da",true);raspunsuri.put("Nu",false);raspunsuri.put("Nu stiu '\' Nu raspund", false);
        this.questions.add(new Question("Iti place sa iti ajuti aproapele?",raspunsuri));
        this.questions.add(new Question("Ai mai facut voluntariat?",raspunsuri));

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void generateMockTests() {

        this.tests=new ArrayList<>();
        tests.add(new Test(1,false,this.questions,10, LocalDateTime.now().plusDays(5),null));

    }

    @Override
    public List<Test> getAllAvailableTests() {
        return null;
    }

    @Override
    public List<Test> getAllTakenTests() {
        return null;
    }
}
