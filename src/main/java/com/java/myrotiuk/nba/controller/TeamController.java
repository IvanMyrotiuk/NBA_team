package com.java.myrotiuk.nba.controller;

import com.java.myrotiuk.nba.entity.Team;
import com.java.myrotiuk.nba.service.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Ivan on 12.01.2019. All rights reserved.
 */
@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamServiceImpl teamServiceImpl;

    @GetMapping(value = "/list")
    public ResponseEntity<List<Team>> listTeam() {
        return ResponseEntity.ok(teamServiceImpl.getAll());
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Team> saveTeam(@RequestBody Team team) {
        return ResponseEntity.ok(teamServiceImpl.save(team));
    }

}
