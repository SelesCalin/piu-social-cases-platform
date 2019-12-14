package com.piu.socialcase.repository;

import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataRepositoryMock {

    public String[] dates;

    public DataRepositoryMock() {
        dates = generateDates();
    }

    private String[] generateDates() {
        String[] dates = new String[]{
                "08:00 - 09:00",
                "09:00 - 10:00",
                "10:00 - 11:00",
                "11:00 - 12:00",
                "12:00 - 13:00",
                "13:00 - 14:00",
                "14:00 - 15:00",
                "15:00 - 16:00",
                "16:00 - 17:00",
                "17:00 - 18:00",
                "18:00 - 19:00",
                "19:00 - 20:00"
        };
        return dates;
    }

    public String[] getDates() {
        return dates;
    }

    public Map<String, Boolean> getAvailableTime(){
        Map<String, Boolean> available = new HashMap<>();
        for(int i = 0; i< dates.length; i++){
            available.put(dates[i],false);
        }
        return available;
    }
}
