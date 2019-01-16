package com.java.myrotiuk.nba.service;

import com.java.myrotiuk.nba.entity.Player;
import com.java.myrotiuk.nba.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ivan on 15.01.2019. All rights reserved.
 */
@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Player save(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public void delete(Long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public List<Player> findAllByTeamId(String id) {
        return playerRepository.findAllByTeamId(id);
    }

    @Override
    @Transactional
    public void connectPlayerWithTeam(Long playerId, String teamId) {
        playerRepository.updateTeamId(playerId, teamId);
    }
}
