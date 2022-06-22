package com.example.demo.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.User.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
