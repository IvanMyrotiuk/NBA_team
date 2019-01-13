package com.java.myrotiuk.nba.repository;

import com.java.myrotiuk.nba.entity.Player;
import org.springframework.stereotype.Repository;

/**
 * Created by Ivan on 13.01.2019. All rights reserved.
 */
@Repository
public interface PlayerRepository extends BaseRepository<Player, Long> {
}
