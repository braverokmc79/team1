
package com.team1.main.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team1.main.dto.MemberDTO;
import com.team1.main.dto.MemberFormDto;
import com.team1.main.entity.Member;
import com.team1.main.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;

	@Transactional
	public Member saveMember(Member member) {
		validateDuplicateMember(member);
		return memberRepository.save(member);
	}

	private void validateDuplicateMember(Member member) {
		Member findMember = memberRepository.findByUserId(member.getUserId());
		log.info("중복회원 검사 :  {} " , findMember);
		if (findMember != null) {
			throw new IllegalStateException("이미 가입된 회원입니다.");
		}
	}

	public MemberDTO loadUserByUsername(String email) throws Exception {
		Member member = memberRepository.findByEmail(email);
		if (member == null) {
			throw new Exception(email);
		}

		return MemberDTO.builder().userId(member.getUserId()).pw(member.getPw()).name(member.getName())
				.gender(member.getGender()).email(member.getEmail()).tel(member.getTel()).birth(member.getBirth())
				.intro(member.getIntro()).build();
	}

	public Member findByEmail(String email) {
		return memberRepository.findByEmail(email);
	}

	
	public Member findByUserId(String userId) {
		return memberRepository.findByUserId(userId);
	}
	
	
	public Member login(MemberFormDto memberFormDto) {
		Member member=Member.createMember(memberFormDto);
		System.out.println(" 멤버 엔티티 정보  : " +member);
		
		return  memberRepository.loginProcess(member.getUserId(), member.getPw());
		
	}

}