package com.piu.socialcase.repository;

import com.piu.socialcase.model.Volunteer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public interface VolunteerRepository {

    Volunteer findVolunteerByUsername(String username);
}
