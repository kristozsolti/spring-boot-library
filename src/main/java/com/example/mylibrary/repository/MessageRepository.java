package com.example.mylibrary.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mylibrary.entity.Message;


@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

	public List<Message> findAll();
	
}
