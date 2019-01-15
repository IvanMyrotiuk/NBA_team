package com.java.myrotiuk.nba.service;

import com.java.myrotiuk.nba.entity.Team;
import com.java.myrotiuk.nba.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Ivan on 13.01.2019. All rights reserved.
 */
@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private ClientTeamService clientTeamService;

    @PostConstruct
    public List<Team> refreshTeams() {
        List<Team> teams = clientTeamService.fetchAll();
        List<Team> dbTeams = getAll();
        List<Team> elemsToDelete = getElemToDelete(teams, dbTeams);
        deleteAll(elemsToDelete);
        return saveAll(teams);
    }

    private <T> List<T> getElemToDelete(List<T> currElems, List<T> dbElems) {
        Set<T> copyCurrElems = new HashSet<>(currElems);
        Set<T> copyDbElems = new HashSet<>(dbElems);
        copyDbElems.removeAll(copyCurrElems);
        return new ArrayList<>(copyDbElems);
    }

    public List<Team> getAll() {
        return teamRepository.findAll();
    }

    public Team save(Team team) {
        return teamRepository.save(team);
    }

    public List<Team> saveAll(List<Team> teams) {
        return teamRepository.saveAll(teams);
    }

    public void deleteAll(List<Team> teams) {
        teamRepository.deleteAll(teams);
    }
}
