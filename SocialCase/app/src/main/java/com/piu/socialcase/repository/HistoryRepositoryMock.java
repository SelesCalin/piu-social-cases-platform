package com.piu.socialcase.repository;

import com.piu.socialcase.model.History;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class HistoryRepositoryMock implements HistoryRepository {

    private List<History> historyList;

    private static HistoryRepositoryMock historyRepositoryMock;

    private HistoryRepositoryMock(){
        historyList = generateHistory();
    }

    public static synchronized HistoryRepositoryMock getInstance(){
        if(historyRepositoryMock == null)
            historyRepositoryMock = new HistoryRepositoryMock();
        return  historyRepositoryMock;
    }

    @Override
    public List<History> getHistoryByVolunteerEmail(String email) {

        List<History> filteredHistory = new ArrayList<>();
        for(History history : historyList)
            if(history.getVolunteerEmail().equals(email))
                filteredHistory.add(history);

        return filteredHistory;
    }

    private List<History> generateHistory() {

        History h1 = new History("calin@gmail.com", "Popescu Ion", new Date(), "Low Battery");
        History h2 = new History("user@user.com", "Daniel Dan", new Date(), "Helped Daniel");
        History h3 = new History("calin@gmail.com", "Mircea Ionescu", new Date(), "Asked for help");
        History h4 = new History("user@user.com", "Vasile Alecsandri", new Date(), "Low Battery");
        History h5 = new History("calin@gmail.com", "Daniel Dan", new Date(), "Assigned case");
        History h6 = new History("calin@gmail.com", "John Brunch", new Date(), "Low Battery");

        return Arrays.asList(h1, h2, h3, h4, h5, h6);
    }
}
