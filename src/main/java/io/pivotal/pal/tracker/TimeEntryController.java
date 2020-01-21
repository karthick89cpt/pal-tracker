package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.util.List;

public class TimeEntryController {

    private TimeEntryRepository repository;

    public TimeEntryController(TimeEntryRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity create(TimeEntry timeEntryToCreate) {
        return null;
    }

    public ResponseEntity<TimeEntry> read(long timeEntryId) {
        return null;
    }

    public ResponseEntity<List<TimeEntry>> list() {
        return null;
    }

    public ResponseEntity update(long timeEntryId, TimeEntry timeEntry) {
        return null;
    }

    public ResponseEntity delete(long timeEntryId) {
        return null;
    }
}
