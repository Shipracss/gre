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

import com.gre.gre.model.PracticeTest;
import com.gre.gre.service.PracticeTestService;

@RestController
@RequestMapping("/api/practicetest")
public class PracticeTestController {

    @Autowired
    private PracticeTestService service;

    @GetMapping
    public List<PracticeTest> list(){
        return service.list();
    }
    @GetMapping("/{id}")
    public PracticeTest get(@PathVariable Long id){
        return service.get(id);
    }
    @PostMapping
    public PracticeTest create(@RequestBody PracticeTest p){
        return service.create(p);
    }
    @PutMapping("/{id}")
    public PracticeTest update(@PathVariable Long id, @RequestBody PracticeTest p){
        return service.update(id, p);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
