package com.piu.socialcase.service;

import com.piu.socialcase.model.History;
import com.piu.socialcase.repository.HistoryRepository;
import com.piu.socialcase.repository.HistoryRepositoryMock;

import java.util.ArrayList;
import java.util.List;

public class HistoryService {

    private HistoryRepository historyRepository;

    public HistoryService() {
        this.historyRepository = HistoryRepositoryMock.getInstance();
    }

    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public List<History> getHistoryByVolunteerEmail(String email) {
        return historyRepository.getHistoryByVolunteerEmail(email);
    }

    public void logActivity(History history){
        historyRepository.logActivity(history);
    }
}
