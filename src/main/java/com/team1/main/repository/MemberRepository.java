package com.team1.main.repository;

import com.team1.main.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByEmail(String email);
    
    @Query("select m from Member m where m.userId=:userId")
    Member findByUserId(@Param("userId") String userId);

    @Nullable
    @Query("select m from Member m where m.userId=:userId  and pw=:pw")
	Member loginProcess(@Param("userId") String userId , @Param("pw") String pw);

}