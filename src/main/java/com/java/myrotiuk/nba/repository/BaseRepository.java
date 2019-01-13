package com.java.myrotiuk.nba.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Ivan on 13.01.2019. All rights reserved.
 */
@NoRepositoryBean
interface BaseRepository<T, ID> extends Repository<T, ID>{

    <S extends T> S save(S var1);

    List<T> findAll();

    Optional<T> findById(ID id);

    void deleteById(ID id);

}
