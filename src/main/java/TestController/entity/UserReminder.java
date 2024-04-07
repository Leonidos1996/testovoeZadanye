package TestController.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "userReminders")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserReminder {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String userName;
    private String city;
    private String password;

    @OneToMany(mappedBy = "userReminder")
    private List<Reminder> reminders;
}
