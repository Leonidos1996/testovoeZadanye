package TestController.repository;


import TestController.entity.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemiderRepo extends JpaRepository<Reminder, Long> {

}
