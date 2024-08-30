package pl.mmank.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mmank.todolist.model.Achievement;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {
}
