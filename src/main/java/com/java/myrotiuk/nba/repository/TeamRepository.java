package com.java.myrotiuk.nba.repository;

import com.java.myrotiuk.nba.entity.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Ivan on 13.01.2019. All rights reserved.
 */
public interface TeamRepository extends BaseRepository<Team, Integer> {
}
