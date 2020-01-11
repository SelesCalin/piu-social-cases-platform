package com.piu.socialcase.repository;

import com.piu.socialcase.model.History;

import java.util.List;

public interface HistoryRepository {

    List<History> getHistoryByVolunteerEmail(String email);
    void logActivity(History history);
}
