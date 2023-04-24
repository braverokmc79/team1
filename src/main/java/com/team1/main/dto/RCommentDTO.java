package com.team1.main.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
// Getter + Setter + RequiredArgsConstructor + ToString + EqualsAndHashCode
public class RCommentDTO {
	
	private Long rcno;
	private String writer;
	private String ori_review;
	private String content;
	private String img;
	private LocalDateTime c_date;
	
}
