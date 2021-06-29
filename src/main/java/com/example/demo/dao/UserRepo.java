package com.example.demo.dao;

import com.example.demo.dao.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {
      UserEntity saveAndFlush(UserEntity user);
      List<UserEntity> findUserEntityByUserName(String userName);
      List<UserEntity> findAll();


}
