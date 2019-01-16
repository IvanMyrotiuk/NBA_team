package com.java.myrotiuk.nba.repository;

import com.java.myrotiuk.nba.entity.Player;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Ivan on 13.01.2019. All rights reserved.
 */
public interface PlayerRepository extends BaseRepository<Player, Long> {

    List<Player> findAllByTeamId(String teamId);

    @Modifying
    @Query("UPDATE Player p SET p.team.id = :teamId WHERE p.id = :playerId")
    void updateTeamId(@Param("playerId") Long playerId, @Param("teamId") String teamId);

}
