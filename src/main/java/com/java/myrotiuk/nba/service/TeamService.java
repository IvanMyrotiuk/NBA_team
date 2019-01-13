package com.java.myrotiuk.nba.service;

import com.java.myrotiuk.nba.entity.Team;
import com.java.myrotiuk.nba.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ivan on 13.01.2019. All rights reserved.
 */
@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    private ClientTeamService clientTeamService;

    public Team save(Team team){
        return teamRepository.save(team);
    }
}
