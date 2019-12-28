package com.piu.socialcase.model;

import java.io.Serializable;

public class Answer implements Serializable {

    private String text;
    private Boolean correct;

    public Answer(String text, Boolean correct) {
        this.text = text;
        this.correct = correct;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }
}
