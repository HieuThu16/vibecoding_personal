package com.personal.manager.service;

import com.personal.manager.model.Skill;
import com.personal.manager.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {

    private final SkillRepository skillRepository;

    @Autowired
    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    public Optional<Skill> getSkillById(Long id) {
        return skillRepository.findById(id);
    }

    public Skill findBySubject(String subject) {
        return skillRepository.findBySubject(subject);
    }

    public Skill saveSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }

    public Optional<Skill> updateSkill(Long id, Skill updatedSkill) {
        Optional<Skill> existingSkill = skillRepository.findById(id);

        if (existingSkill.isPresent()) {
            Skill skill = existingSkill.get();
            skill.setSubject(updatedSkill.getSubject());
            skill.setValue(updatedSkill.getValue());
            skill.setFullMark(updatedSkill.getFullMark());

            return Optional.of(skillRepository.save(skill));
        }

        return Optional.empty();
    }

    public Skill updateSkillValue(String subject, double value) {
        Skill skill = skillRepository.findBySubject(subject);

        if (skill != null) {
            skill.setValue(value);
            return skillRepository.save(skill);
        }

        return null;
    }

    public List<Skill> updateAllSkills(List<Skill> skills) {
        for (Skill skill : skills) {
            Skill existingSkill = skillRepository.findBySubject(skill.getSubject());
            if (existingSkill != null) {
                existingSkill.setValue(skill.getValue());
                skillRepository.save(existingSkill);
            } else {
                skillRepository.save(skill);
            }
        }

        return skillRepository.findAll();
    }
}
