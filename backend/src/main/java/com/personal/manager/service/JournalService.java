package com.personal.manager.service;

import com.personal.manager.model.JournalEntry;
import com.personal.manager.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JournalService {

    private final JournalRepository journalRepository;

    @Autowired
    public JournalService(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    public List<JournalEntry> getAllEntries() {
        return journalRepository.findAllByOrderByDateDesc();
    }

    public Optional<JournalEntry> getEntryById(Long id) {
        return journalRepository.findById(id);
    }

    public JournalEntry saveEntry(JournalEntry entry) {
        if (entry.getDate() == null) {
            entry.setDate(LocalDateTime.now());
        }
        return journalRepository.save(entry);
    }

    public void deleteEntry(Long id) {
        journalRepository.deleteById(id);
    }

    public Optional<JournalEntry> updateEntry(Long id, JournalEntry updatedEntry) {
        Optional<JournalEntry> existingEntry = journalRepository.findById(id);

        if (existingEntry.isPresent()) {
            JournalEntry entry = existingEntry.get();
            entry.setTitle(updatedEntry.getTitle());
            entry.setContent(updatedEntry.getContent());

            if (updatedEntry.getDate() != null) {
                entry.setDate(updatedEntry.getDate());
            }

            return Optional.of(journalRepository.save(entry));
        }

        return Optional.empty();
    }
}
