package com.gre.gre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gre.gre.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}