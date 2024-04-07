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
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/reminder")
public class ReminderController {

    private final ReminderService reminderService;

    @PostMapping("/create")
    public ResponseEntity<Reminder> create (@RequestBody ReminderDTO dto){
        return new ResponseEntity<>(reminderService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Reminder>> readAll() {
        return new ResponseEntity<>(reminderService.readAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Reminder> update (@RequestBody Reminder reminder){
        return new ResponseEntity<>(reminderService.update(reminder), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete (@PathVariable Long id){
        reminderService.delete(id);
        return HttpStatus.OK;
    }


}
