package com.example.mylibrary.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.mylibrary.entity.UserInfo;

public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {

}
