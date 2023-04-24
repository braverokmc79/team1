package com.team1.main.repository;

import com.team1.main.entity.Board;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface BoardRepository extends JpaRepository<Board, Long>, QuerydslPredicateExecutor<Item> , BoardRepositoryCustom{
	

}

