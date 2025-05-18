package com.personal.manager.controller;

import com.personal.manager.model.JournalEntry;
import com.personal.manager.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/journal")
@CrossOrigin(origins = "*")
public class JournalController {

    private final JournalService journalService;

    @Autowired
    public JournalController(JournalService journalService) {
        this.journalService = journalService;
    }

    @GetMapping("/entries")
    public ResponseEntity<List<JournalEntry>> getAllEntries() {
        List<JournalEntry> entries = journalService.getAllEntries();
        return new ResponseEntity<>(entries, HttpStatus.OK);
    }

    @GetMapping("/entries/{id}")
    public ResponseEntity<JournalEntry> getEntryById(@PathVariable Long id) {
        Optional<JournalEntry> entry = journalService.getEntryById(id);
        return entry.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/entries")
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry entry) {
        JournalEntry savedEntry = journalService.saveEntry(entry);
        return new ResponseEntity<>(savedEntry, HttpStatus.CREATED);
    }

    @PutMapping("/entries/{id}")
    public ResponseEntity<JournalEntry> updateEntry(@PathVariable Long id, @RequestBody JournalEntry entry) {
        Optional<JournalEntry> updatedEntry = journalService.updateEntry(id, entry);
        return updatedEntry.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/entries/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable Long id) {
        journalService.deleteEntry(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
