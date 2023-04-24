package com.team1.main.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnnounceDTO {
	private Long aNo;
	private Long id;
	private String title;
	private String content;
	private LocalDateTime regDate, modDate;
	private String img;
}
