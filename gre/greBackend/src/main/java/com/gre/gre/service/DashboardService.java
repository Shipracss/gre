package com.gre.gre.service;

import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gre.gre.dto.DashboardData;
import com.gre.gre.model.PracticeTest;
import com.gre.gre.model.ScoreEntry;
import com.gre.gre.repository.PracticeTestRepository;
@Service
public class DashboardService {

    @Autowired
    private PracticeTestRepository practiceTestRepository;

    public DashboardData getDashboardData(Long userId) {
        List<PracticeTest> tests = practiceTestRepository.findByUserIdOrderByTestDateAsc(userId);

        DashboardData data = new DashboardData();

        data.setCompletedTests(tests.size());

        
        data.setTotalHours(tests.size() * 2);

        
        double avg = tests.stream()
            .mapToInt(t -> t.getVerbalScore() + t.getQuantScore())
            .average()
            .orElse(0);
        data.setAvgScore((int) avg);

        
        List<ScoreEntry> progression = tests.stream()
            .map(t -> new ScoreEntry(
                t.getTestDate().toString(),
                t.getVerbalScore(),
                t.getQuantScore()
            ))
            .collect(Collectors.toList());
        data.setScoreProgression(progression);


        int streak = calculateStreakCount(tests);
        data.setStreakCount(streak);

        return data;
    }

    private int calculateStreakCount(List<PracticeTest> tests) {
        if (tests.isEmpty()) return 0;

        tests.sort(Comparator.comparing(PracticeTest::getTestDate));
        int streak = 1;
        int maxStreak = 1;

        for (int i = 1; i < tests.size(); i++) {
            long daysBetween = ChronoUnit.DAYS.between(tests.get(i - 1).getTestDate(), tests.get(i).getTestDate());
            if (daysBetween == 1) {
                streak++;
                maxStreak = Math.max(maxStreak, streak);
            } else if (daysBetween > 1) {
                streak = 1;
            }
        }

        return maxStreak;
    }
}
