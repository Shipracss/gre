package com.gre.gre.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name = "StudyPlan")
public class StudyPlan {
 

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;
    private String planName;
    private LocalDate startDate;
    private LocalDate targetTestDate;
    private String intensity;

    @ElementCollection
    private List<String> focusAreas; 
    
    @ElementCollection
    private Map<String, Integer> currentScores;

    @ElementCollection
    private Map<String, Integer> targetScores;
}

