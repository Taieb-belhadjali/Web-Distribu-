package com.example.skillsservice.service;

import com.example.skillsservice.entity.Skill;
import com.example.skillsservice.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    @Autowired
    private SkillRepository repository;

    public Skill create(Skill s) {
        return repository.save(s);
    }

    public Skill get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found"));
    }

    public List<Skill> getAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    // ✅ UPDATE
    public Skill update(Long id, Skill newSkill) {
        Skill existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found"));

        existing.setName(newSkill.getName());
        existing.setType(newSkill.getType());

        return repository.save(existing);
    }
}
