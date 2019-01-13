package com.java.myrotiuk.nba.service;

import com.java.myrotiuk.nba.entity.Team;
import com.java.myrotiuk.nba.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

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
    public List<Team> refreshTeams(){
        List<Team> teams = fetchTeams();
        List<Team> dbTeams = getAll();
        return teams;
    }

    private List<Team> fetchTeams(){
        return clientTeamService.fetchAll();
    }

    public List<Team> getAll(){
        return teamRepository.findAll();
    }

    public Team save(Team team){
        return teamRepository.save(team);
    }
}
