package com.personal.manager.controller;

import com.personal.manager.model.Skill;
import com.personal.manager.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin(origins = "*")
public class SkillController {

    private final SkillService skillService;

    @Autowired
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping
    public ResponseEntity<List<Skill>> getAllSkills() {
        List<Skill> skills = skillService.getAllSkills();
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Skill> getSkillById(@PathVariable Long id) {
        Optional<Skill> skill = skillService.getSkillById(id);
        return skill.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/subject/{subject}")
    public ResponseEntity<Skill> getSkillBySubject(@PathVariable String subject) {
        Skill skill = skillService.findBySubject(subject);
        if (skill != null) {
            return new ResponseEntity<>(skill, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Skill> createSkill(@RequestBody Skill skill) {
        Skill savedSkill = skillService.saveSkill(skill);
        return new ResponseEntity<>(savedSkill, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Skill> updateSkill(@PathVariable Long id, @RequestBody Skill skill) {
        Optional<Skill> updatedSkill = skillService.updateSkill(id, skill);
        return updatedSkill.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PatchMapping("/subject/{subject}")
    public ResponseEntity<Skill> updateSkillValue(
            @PathVariable String subject,
            @RequestParam double value) {
        Skill updatedSkill = skillService.updateSkillValue(subject, value);
        if (updatedSkill != null) {
            return new ResponseEntity<>(updatedSkill, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<List<Skill>> updateAllSkills(@RequestBody List<Skill> skills) {
        List<Skill> updatedSkills = skillService.updateAllSkills(skills);
        return new ResponseEntity<>(updatedSkills, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
