package com.example.mylibrary.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mylibrary.entity.ContactMessage;


@Repository
public interface ContactMessageRepository extends CrudRepository<ContactMessage, Long> {

	public List<ContactMessage> findAllByOrderByArrivalDateDesc();
	
	public List<ContactMessage> findAllByIsDeletedFalseOrderByArrivalDateDesc();
	
}
