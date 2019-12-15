package com.piu.socialcase.model;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Timer;

public class Test {


    private int testNo;

    private Boolean taken;

    private List<Question> questions;

    private LocalTime time;

    private LocalDateTime deadline;

    private LocalDateTime dayTaken;

    public Test(int testNo, Boolean taken, List<Question> questions, LocalTime time, LocalDateTime deadline, LocalDateTime dayTaken) {
        this.testNo = testNo;
        this.taken = taken;
        this.questions = questions;
        this.time = time;
        this.deadline = deadline;
        this.dayTaken = dayTaken;
    }

    public int getTestNo() {
        return testNo;
    }

    public void setTestNo(int testNo) {
        this.testNo = testNo;
    }

    public Boolean getTaken() {
        return taken;
    }

    public void setTaken(Boolean taken) {
        this.taken = taken;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public LocalDateTime getDayTaken() {
        return dayTaken;
    }

    public void setDayTaken(LocalDateTime dayTaken) {
        this.dayTaken = dayTaken;
    }
}
