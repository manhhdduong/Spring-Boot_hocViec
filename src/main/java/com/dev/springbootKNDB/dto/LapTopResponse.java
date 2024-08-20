package com.dev.springbootKNDB.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LapTopResponse {
    private String id;

    private String name;

    private String imei;

    private Double size;

    private Double price;

    private String description;
}
