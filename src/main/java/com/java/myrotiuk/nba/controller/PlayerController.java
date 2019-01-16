package com.java.myrotiuk.nba.controller;

import com.java.myrotiuk.nba.dto.PlayerDTO;
import com.java.myrotiuk.nba.entity.Player;
import com.java.myrotiuk.nba.service.PlayerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Ivan on 15.01.2019. All rights reserved.
 */
@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Player> savePlayer(@RequestBody PlayerDTO playerDTO) {
        Player player = modelMapper.map(playerDTO, Player.class);
        return ResponseEntity.ok(playerService.save(player));
    }

    @DeleteMapping(value = "/{id}")
    public void deletePlayer(@PathVariable Long id) {
        playerService.delete(id);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Player>> listPlayers() {
        return ResponseEntity.ok(playerService.findAll());
    }

    @GetMapping(value = "/list/team/{id}")
    public ResponseEntity<List<PlayerDTO>> listPlayersForTeam(@PathVariable String id) {
        List<PlayerDTO> playerDTOList = playerService.findAllByTeamId(id)
                .stream()
                .map(p -> modelMapper.map(p, PlayerDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(playerDTOList);
    }

    @PutMapping(value = "/{playerId}/team/{teamId}")
    @ResponseStatus(HttpStatus.OK)
    public void enrollPlayerToATeam(@PathVariable Long playerId, @PathVariable String teamId) {
        playerService.connectPlayerWithTeam(playerId, teamId);
    }
}
