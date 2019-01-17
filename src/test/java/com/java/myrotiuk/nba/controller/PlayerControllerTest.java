package com.java.myrotiuk.nba.controller;

import com.java.myrotiuk.nba.dto.PlayerDTO;
import com.java.myrotiuk.nba.entity.Player;
import com.java.myrotiuk.nba.service.PlayerService;
import com.java.myrotiuk.nba.util.TestUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Ivan on 17.01.2019. All rights reserved.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=dev")
@AutoConfigureMockMvc
@ComponentScan(basePackages = "com.java.myrotiuk.nba", excludeFilters = {@Filter(type = ASSIGNABLE_TYPE,
        value = {TeamController.class})})
public class PlayerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerService playerServiceMock;

    @Test
    public void shouldSavePlayerAndReturnPlayer() throws Exception {
        PlayerDTO playerDTO = PlayerDTO.builder()
                .name("John")
                .phone("411-45-55")
                .height(181).build();

        Player player = Player.builder()
                .id(1L)
                .name("John")
                .phone("411-45-55")
                .height(181)
                .team(null).build();

        when(playerServiceMock.save(any(Player.class))).thenReturn(player);

        mockMvc.perform(post("/player")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(playerDTO))
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("John")))
                .andExpect(jsonPath("$.phone", is("411-45-55")))
                .andExpect(jsonPath("$.height", is(181)))
                .andExpect(jsonPath("$.team", is(nullValue())));

        ArgumentCaptor<Player> playerCaptor = ArgumentCaptor.forClass(Player.class);
        verify(playerServiceMock, times(1)).save(playerCaptor.capture());
        verifyNoMoreInteractions(playerServiceMock);

        Player playerArgument = playerCaptor.getValue();
        assertNull(playerArgument.getId());
        assertThat(playerArgument.getName(), is("John"));
        assertThat(playerArgument.getPhone(), is("411-45-55"));
        assertThat(playerArgument.getHeight(), is(181));
        assertThat(playerArgument.getTeam(), is(nullValue()));

    }

}