package com.gre.gre.dto;

import java.util.List;

import com.gre.gre.model.ScoreEntry;

import lombok.Data;

@Data
public class DashboardData {
    private int totalHours;
    private int completedTests;
    private int avgScore;
    private List<ScoreEntry> scoreProgression;
    private int streakCount;
}
