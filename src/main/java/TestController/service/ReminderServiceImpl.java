package TestController.service;

import TestController.DTO.ReminderDTO;
import TestController.entity.Reminder;
import TestController.repository.RemiderRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ReminderServiceImpl implements ReminderService {

    private final RemiderRepo reminderRepo;


    @Override
    public Reminder createReminder(Reminder reminder) {
        Reminder reminderCreation = Reminder.builder()
                .title(reminder.getTitle())
                .description(reminder.getDescription())
                .remind(reminder.getRemind())
                .build();
        return reminderRepo.save(reminder);
    }

    @Override
    public List<Reminder> findByTitleContaining(String title) {
        return reminderRepo.findByTitleContaining(title);
    }

    @Override
    public List<Reminder> findByDescriptionContaining(String description) {
        return reminderRepo.findByDescriptionContaining(description);
    }

    @Override
    public List<Reminder> findByRemindBetween(LocalDateTime start, LocalDateTime end) {
        return reminderRepo.findByRemindBetween(start, end);
    }

    @Override
    public List<Reminder> findAllByOrderByTitleAsc() {
        return reminderRepo.findAllByOrderByTitleAsc();
    }

    @Override
    public List<Reminder> findAllByOrderByRemindAsc() {
        return reminderRepo.findAllByOrderByRemindAsc();
    }


//    public Reminder create (ReminderDTO dto){
//        Reminder reminder = Reminder.builder()
//                .title(dto.getTitle())
//                .description(dto.getDescription())
//                .remind(dto.getRemind())
//                .build();
//        return reminderRepo.save(reminder);
//    }
//
//    public List<Reminder> readAll(){
//        return reminderRepo.findAll();
//    }
//
//
//
//    public Reminder update (Reminder reminder) {
//        return reminderRepo.save(reminder);
//    }
//
//    public void delete (Long id){
//        reminderRepo.deleteById(id);
//    }

}
