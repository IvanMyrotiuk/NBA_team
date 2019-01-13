package com.java.myrotiuk.nba.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Ivan on 13.01.2019. All rights reserved.
 */
@Entity(name = "team")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team implements Serializable{

    @Id
    @Column(name = "team_id")
    @JsonProperty("team_id")
    private String id;

    private String abbreviation;

    private Boolean active;

    @Column(name = "first_name")
    @JsonProperty("first_name")
    private String firstName;

    @Column(name = "last_name")
    @JsonProperty("last_name")
    private String lastName;

    private String conference;

    private String division;

    @Column(name = "site_name")
    @JsonProperty("site_name")
    private String siteName;

    private String city;

    private String state;

    @Column(name = "full_name")
    @JsonProperty("full_name")
    private String fullName;
}
