package TestController.DTO;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
public class ReminderDTO {

    private String title;
    private String description;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private LocalDateTime remind;


}
