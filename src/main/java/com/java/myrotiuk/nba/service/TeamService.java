package com.java.myrotiuk.nba.service;

import com.java.myrotiuk.nba.entity.Team;

import java.util.List;

/**
 * Created by Ivan on 15.01.2019. All rights reserved.
 */
public interface TeamService {
    List<Team> refreshTeams();

    List<Team> getAll();

    Team save(Team team);

    List<Team> saveAll(List<Team> teams);

    void deleteAll(List<Team> teams);

}
