package com.java.myrotiuk.nba.service;

import com.java.myrotiuk.nba.entity.Player;
import com.java.myrotiuk.nba.entity.Team;
import com.java.myrotiuk.nba.repository.TeamRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by Ivan on 17.01.2019. All rights reserved.
 */
public class TeamServiceImplTest {

    @Mock
    private ClientTeamService clientTeamService;

    @Mock
    private TeamRepository teamRepository;

    @Captor
    private ArgumentCaptor<ArrayList<Team>> teamCaptor;

    @InjectMocks
    private TeamServiceImpl teamService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void refreshTeams() throws Exception {
        Team team = Team.builder().id("atlanta-hawks").build();
        Team team2 = Team.builder().id("boston-celtics").build();
        Team team3 = Team.builder().id("chicago-bulls").build();

        when(clientTeamService.fetchAll()).thenReturn(Arrays.asList(team, team2));
        when(teamRepository.findAll()).thenReturn(Arrays.asList(team, team2, team3));
        when(teamRepository.saveAll(ArgumentMatchers.<Team>anyList())).thenReturn(Arrays.asList(team, team2));

        teamService.refreshTeams();

        verify(teamRepository, times(1)).deleteAll(teamCaptor.capture());
        assertThat(teamCaptor.getValue(), is(Collections.singletonList(team3)));

        verify(teamRepository, times(1)).saveAll(teamCaptor.capture());
        assertThat(teamCaptor.getValue(), is(Arrays.asList(team, team2)));
    }

}