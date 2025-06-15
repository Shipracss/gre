package com.gre.gre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gre.gre.model.PracticeTest;

@Repository
public interface PracticeTestRepository extends JpaRepository<PracticeTest, Long> {

      List<PracticeTest> findByUserIdOrderByTestDateAsc(Long userId);
}