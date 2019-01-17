package com.java.myrotiuk.nba.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Ivan on 15.01.2019. All rights reserved.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {
    private String name;
    private String phone;
    private Integer height;
}
