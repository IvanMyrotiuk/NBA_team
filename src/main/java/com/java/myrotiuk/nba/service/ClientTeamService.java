package com.java.myrotiuk.nba.service;

import com.java.myrotiuk.nba.entity.Team;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.java.myrotiuk.nba.util.RestUtil.getRestTemplateWithoutSSLValidation;

/**
 * Created by Ivan on 13.01.2019. All rights reserved.
 */
@Service
@Slf4j
class ClientTeamService {

    @Value("${teams.url}")
    private String url;

    List<Team> fetchAll() {
        try {
            RestTemplate rt = getRestTemplateWithoutSSLValidation();
            rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            rt.getMessageConverters().add(new StringHttpMessageConverter());
            Team[] team = rt.getForObject(url, Team[].class);
            return Arrays.asList(team);
        } catch (Exception e) {
            log.error("Could not fetch teams: " + e.getMessage());
            return Collections.EMPTY_LIST;
        }
    }
}
