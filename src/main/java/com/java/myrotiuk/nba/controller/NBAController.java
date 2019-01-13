package com.java.myrotiuk.nba.controller;

import com.java.myrotiuk.nba.entity.Team;
import com.java.myrotiuk.nba.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ivan on 12.01.2019. All rights reserved.
 */
@RestController
public class NBAController {

    @Autowired
    private TeamService teamService;

    @GetMapping(value = "/", produces = "application/json")
    public String hello() {
        return "Hello World and NBA!!!";
    }


    @PostMapping(value = "/team/add", consumes = "application/json")
    public ResponseEntity<Team> saveTeam(@RequestBody Team team) {
        return new ResponseEntity<>(teamService.save(team), HttpStatus.OK);
    }

}
