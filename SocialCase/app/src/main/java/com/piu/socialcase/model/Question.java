package com.piu.socialcase.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class Question implements Serializable {

    private String question;

    private List<Answer> answears; //true as value if its the correct answear;

    public Question(String question, List<Answer> answears) {
        this.question = question;
        this.answears = answears;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswears() {
        return answears;
    }

    public void setAnswears(List<Answer> answears) {
        this.answears = answears;
    }
}

