package io.pivotal.pal.tracker;

import java.sql.Time;
import java.util.*;
import java.util.stream.Collectors;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private Map<Long, TimeEntry> timeEntryMap = new HashMap<>();
    private Long idCounter = 1L;

    public TimeEntry create(TimeEntry timeEntry) {
        TimeEntry newEntry = new TimeEntry(idCounter, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        timeEntryMap.put(idCounter++, newEntry);
        return newEntry;
    }

    public TimeEntry find(long timeEntryId) {
        return timeEntryMap.get(timeEntryId);
    }

    public List<TimeEntry> list() {
        return timeEntryMap.values().stream().collect(Collectors.toList());
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        TimeEntry timeEntryToUpdate = timeEntryMap.get(id);
        if (timeEntryToUpdate != null) {
            timeEntryToUpdate.setProjectId(timeEntry.getProjectId());
            timeEntryToUpdate.setUserId(timeEntry.getUserId());
            timeEntryToUpdate.setDate(timeEntry.getDate());
            timeEntryToUpdate.setHours(timeEntry.getHours());
            return timeEntryMap.put(id, timeEntryToUpdate);
        }
        return null;
    }

    public void delete(long id) {
        timeEntryMap.remove(id);
    }
}
