package TestController.repository;


import TestController.entity.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RemiderRepo extends JpaRepository<Reminder, Long> {

    List<Reminder> findByTitleContaining(String title);

    List<Reminder> findByDescriptionContaining(String description);

    List<Reminder> findByRemindBetween(LocalDateTime start, LocalDateTime end);

    List<Reminder> findAllByOrderByTitleAsc();

    List<Reminder> findAllByOrderByRemindAsc();

}
