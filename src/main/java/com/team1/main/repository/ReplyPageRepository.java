package com.team1.main.repository;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.team1.main.entity.Reply;


public interface ReplyPageRepository extends JpaRepository<Reply, Long>, QuerydslPredicateExecutor<Item> , ReplyRepositoryCustom{
	
}

