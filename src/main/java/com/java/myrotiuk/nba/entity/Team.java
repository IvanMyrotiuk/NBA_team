package com.java.myrotiuk.nba.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Ivan on 13.01.2019. All rights reserved.
 */
@Entity(name = "team")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team implements Serializable{

    @Id
    @SequenceGenerator(name = "team_id_seq", sequenceName = "team_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "team_id_seq")
    private Integer id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
    private Set<Player> players;

    private String name;

}
