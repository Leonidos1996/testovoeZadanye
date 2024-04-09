package TestController.service;

import TestController.entity.Reminder;

import java.time.LocalDateTime;
import java.util.List;

public interface ReminderService {

    Reminder createReminder(Reminder reminder);
    List<Reminder> findByTitleContaining(String title);
    List<Reminder> findByDescriptionContaining(String description);
    List<Reminder> findByRemindBetween(LocalDateTime start, LocalDateTime end);
    List<Reminder> findAllByOrderByTitleAsc();
    List<Reminder> findAllByOrderByRemindAsc();
}
