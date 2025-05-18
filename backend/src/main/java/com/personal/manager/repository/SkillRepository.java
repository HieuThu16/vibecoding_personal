package com.personal.manager.repository;

import com.personal.manager.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

    Skill findBySubject(String subject);
}
