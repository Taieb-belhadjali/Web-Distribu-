package com.example.skillsservice.controller;

import com.example.skillsservice.entity.Skill;
import com.example.skillsservice.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

    @Autowired
    private SkillService service;

    @PostMapping
    public Skill create(@RequestBody Skill s) {
        return service.create(s);
    }

    @GetMapping("/{id}")
    public Skill get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    public List<Skill> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Skill update(@PathVariable Long id, @RequestBody Skill s) {
        return service.update(id, s);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
