package com.piu.socialcase.model;

import java.io.Serializable;
import java.util.HashMap;

public class Question implements Serializable {

    private String question;

    private HashMap<String, Boolean> answears; //true as value if its the correct answear;

    public Question(String question, HashMap<String, Boolean> answears) {
        this.question = question;
        this.answears = answears;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public HashMap<String, Boolean> getAnswears() {
        return answears;
    }

    public void setAnswears(HashMap<String, Boolean> answears) {
        this.answears = answears;
    }
}
