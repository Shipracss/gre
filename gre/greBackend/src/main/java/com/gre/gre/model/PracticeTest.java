package com.gre.gre.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name = "PracticeTest")
public class PracticeTest {


    @Id
    @GeneratedValue
    private Long id;

    private Long userId;
    private LocalDate testDate;
    private String testType;
    private Integer verbalScore;
    private Integer quantScore;
    private Double awaScore;
    private String improvementAreas;
    private Boolean simulatedConditions;
}

