package com.team1.main.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.team1.main.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long>{
//
//	
//	 create table reply (
//		       id bigint not null,
//		        content varchar(200) not null,
//		        create_date timestamp,
//		        board_id bigint,
//		        user_id varchar(50),
//		        primary key (id)
//		    )
//	 
	 
	@Transactional
	@Modifying
	@Query(value="INSERT INTO `reply` (id, user_id, board_id, content, create_date ) VALUES(reply_seq.NEXTVAL, :userId, :boardId, :content, now() )", nativeQuery = true)
	int mSave(@Param("userId") String userId, @Param("boardId") long boardId, @Param("content") String content);

	
	@Modifying
	@Query(value="SELECT r.id, r.content , r.board_id as boardId , r.user_id as userId, r.create_date , "
			+ "(select m.name from `member` m  where m.userId=r.userId) as name "			
			+ "FROM reply r "
			+ " WHERE r.board_id =:boardId  ORDER BY r.create_date DESC ", nativeQuery = true)
	List<Reply>  replyList( @Param("boardId") Long id);
  
	
	
	@Query(value="SELECT count(*) as cnt FROM reply r WHERE r.board_id = :boardId ", nativeQuery = true)
	int replyTotalCount( @Param("boardId") Long boardId);
	
	

		        
		       
}
