package TestController.controller;


import TestController.DTO.ReminderDTO;
import TestController.entity.Reminder;
import TestController.service.ReminderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/reminder")
public class ReminderController {

    private final ReminderService reminderService;

    @PostMapping("/create")
    public ResponseEntity<Reminder> create (@RequestBody Reminder reminder){
        return new ResponseEntity<>(reminderService.createReminder(reminder), HttpStatus.OK);
    }


    @GetMapping("/search/title")
    public ResponseEntity<List<Reminder>> searchByTitle(@RequestParam String title) {
        return new ResponseEntity<>(reminderService.findByTitleContaining(title), HttpStatus.OK);
    }


    @GetMapping("/search/description")
    public ResponseEntity<List<Reminder>> searchByDescription(@RequestParam String description) {
        return new ResponseEntity<>(reminderService.findByDescriptionContaining(description), HttpStatus.OK);
    }

    @GetMapping("/search/date")
    public ResponseEntity<List<Reminder>> searchByDate(@RequestParam LocalDateTime start, LocalDateTime end) {
        return new ResponseEntity<>(reminderService.findByRemindBetween(start, end), HttpStatus.OK);
    }

    @GetMapping("/sort/title")
    public List<Reminder> sortByTitle() {
        return reminderService.findAllByOrderByTitleAsc();
    }

    @GetMapping("/sort/remind")
    public List<Reminder> sortByRemind() {
        return reminderService.findAllByOrderByRemindAsc();
    }



//    @GetMapping
//    public ResponseEntity<List<Reminder>> readAll() {
//        return new ResponseEntity<>(reminderService.readAll(), HttpStatus.OK);
//    }
//
//    @PutMapping
//    public ResponseEntity<Reminder> update (@RequestBody Reminder reminder){
//        return new ResponseEntity<>(reminderService.update(reminder), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public HttpStatus delete (@PathVariable Long id){
//        reminderService.delete(id);
//        return HttpStatus.OK;
//    }


}
