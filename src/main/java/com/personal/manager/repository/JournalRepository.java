package com.personal.manager.repository;

import com.personal.manager.model.JournalEntry;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepository extends JpaRepository<JournalEntry, Long> {

    List<JournalEntry> findAllByOrderByDateDesc();
}
