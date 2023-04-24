package com.team1.main.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberDTO {
	private String id;
	private String userId;
	private String pw;
	private String name;
	private String gender;
	private String email;
	private String tel;
	private String birth;
	private String intro;
}
