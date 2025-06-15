package com.gre.gre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gre.gre.model.StudyPlan;
import com.gre.gre.repository.StudyPlanRepository;

@Service
public class StudyPlanService {

    @Autowired
    private StudyPlanRepository repo;

    public List<StudyPlan> list(){
        return repo.findAll();
    }

    public StudyPlan get(Long id){
        return repo.findById(id).orElseThrow();
    }
    public StudyPlan create(StudyPlan s){
        return repo.save(s);
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
    public StudyPlan update(Long id, StudyPlan s){

        StudyPlan exist = get(id);
        exist.setCurrentScores(s.getCurrentScores());
        exist.setFocusAreas(s.getFocusAreas());
        exist.setIntensity(s.getIntensity());
        exist.setPlanName(s.getPlanName());
        exist.setStartDate(s.getStartDate());
        exist.setTargetScores(s.getTargetScores());
        exist.setTargetTestDate(s.getTargetTestDate());
        exist.setUserId(s.getUserId());
        return repo.save(exist);
    }
}
