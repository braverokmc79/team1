package com.team1.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.UniqueElements;

import com.team1.main.dto.MemberFormDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(of= {"userId","name","pw", "gender","email","tel", "birth"})
@Table(name = "MEMBER")
public class Member {
 

	@Id
	@Column(name = "userId", length = 50)
	private String userId;

	@Column(name = "pw", length = 50)
	private String pw;

	@Column(name = "name", length = 50)
	private String name;

	@Column(name = "gender", length = 50)
	private String gender;

	@Column(name = "email", length = 50)
	private String email;

	@Column(name = "tel", length = 50)
	private String tel;

	@Column(name = "birth", length = 50)
	private String birth;

	@Column(name = "intro", length = 1500)
	private String intro;

	
	
	public static Member createMember(MemberFormDto memberFormDto) {
		return Member.builder().userId(memberFormDto.getUserId()).pw(memberFormDto.getPassword())
				.name(memberFormDto.getName()).gender(memberFormDto.getGender()).email(memberFormDto.getEmail())
				.tel(memberFormDto.getTel()).birth(memberFormDto.getBirth()).intro(memberFormDto.getIntro()).build();
	
	}

}
