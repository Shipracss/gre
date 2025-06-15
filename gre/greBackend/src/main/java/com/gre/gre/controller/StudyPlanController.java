package com.gre.gre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gre.gre.model.StudyPlan;
import com.gre.gre.service.StudyPlanService;

@RestController
@RequestMapping("/api/studyplan")
public class StudyPlanController {

    @Autowired
    private StudyPlanService service;

    @GetMapping
    public List<StudyPlan> list(){
        return service.list();
    }
    @GetMapping("/{id}")
    public StudyPlan get(@PathVariable Long id){
        return service.get(id);
    }
    @PostMapping
public StudyPlan create(@RequestBody StudyPlan s){
    System.out.println("Received StudyPlan: " + s);
    return service.create(s);
}

    @PutMapping("/{id}")
    public StudyPlan update(@PathVariable Long id, @RequestBody StudyPlan s)
    {
        return service.update(id, s);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
