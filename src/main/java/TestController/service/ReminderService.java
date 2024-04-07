package TestController.service;

import TestController.DTO.ReminderDTO;
import TestController.entity.Reminder;
import TestController.repository.RemiderRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReminderService {

    private final RemiderRepo reminderRepo;

    public Reminder create (ReminderDTO dto){
            Reminder reminder = Reminder.builder()
                    .title(dto.getTitle())
                    .description(dto.getDescription())
                    .remind(dto.getRemind())
                    .build();
        return reminderRepo.save(reminder);
    }

    public List<Reminder> readAll(){
        return reminderRepo.findAll();
    }

    public Reminder update (Reminder reminder) {
        return reminderRepo.save(reminder);
    }

    public void delete (Long id){
        reminderRepo.deleteById(id);
    }


}
