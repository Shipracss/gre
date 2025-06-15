package com.gre.gre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gre.gre.model.PracticeTest;
import com.gre.gre.repository.PracticeTestRepository;

@Service
public class PracticeTestService {
    @Autowired
    private PracticeTestRepository repo;

    public List<PracticeTest> list(){ return repo.findAll();}
    public PracticeTest get(Long id){
        return repo.findById(id).orElseThrow(null);
    }
    public PracticeTest create(PracticeTest p){
        return repo.save(p);
    }
    public void delete(Long id){ 
        repo.deleteById(id);
    }
    public PracticeTest update(Long id, PracticeTest p){
        PracticeTest exist = get(id);
        exist.setAwaScore(p.getAwaScore());
        exist.setImprovementAreas(p.getImprovementAreas());
        exist.setQuantScore(p.getQuantScore());
        exist.setSimulatedConditions(p.getSimulatedConditions());
        exist.setTestDate(p.getTestDate());
        exist.setTestType(p.getTestType());
        exist.setUserId(p.getUserId());
        exist.setVerbalScore(p.getVerbalScore());

        return repo.save(exist);

    }

}
