package com.java.myrotiuk.nba.service;

import com.java.myrotiuk.nba.entity.Player;

import java.util.List;

/**
 * Created by Ivan on 15.01.2019. All rights reserved.
 */
public interface PlayerService {

    Player save(Player player);

    void delete(Long id);

    List<Player> findAll();

    List<Player> findAllByTeamId(String id);

    void connectPlayerWithTeam(Long playerId, String teamId);
}
