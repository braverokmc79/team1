package com.team1.main.
dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OfferDTO {

    private Long ono;
    private String id;
    private String title;
    private String img;
    private String category;
    private String region;
    private String content;
    private String map;
    private LocalDateTime regDate, modDate;
}
