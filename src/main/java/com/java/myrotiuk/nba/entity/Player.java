package com.java.myrotiuk.nba.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by Ivan on 13.01.2019. All rights reserved.
 */
@Entity(name = "player")
@Data
@NoArgsConstructor
public class Player implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    private String name;
    private String phone;
    private Integer height;

}
