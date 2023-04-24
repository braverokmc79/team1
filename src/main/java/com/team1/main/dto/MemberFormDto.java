package com.team1.main.dto;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.team1.main.entity.Member;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter 
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberFormDto {

    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String name;

 
    private String email;

    @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
    @Length(min=8, max=16, message = "비밀번호는 8자 이상, 16자 이하로 입력해주세요")
    private String password;

 
    private String address;
    
	private String userId;
	
	private String gender;
	
	private String tel;
	

	private String birth;
	

	private String intro;
	
	
	public static MemberFormDto createMemberDTO(Member member) {
		return MemberFormDto.builder().userId(member.getUserId()).password(member.getPw())
				.name(member.getName()).gender(member.getGender()).email(member.getEmail())
				.tel(member.getTel()).birth(member.getBirth()).intro(member.getIntro()).build();
	}


	
	
}