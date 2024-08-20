package com.dev.springbootKNDB.dto;

import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LapTopRequest {

    private String name;
    @Size(min = 3, message = "emei co so ki tu toi thieu la 3!")
    private String imei;

    private Double size;

    private Double price;

    private String description;
}
