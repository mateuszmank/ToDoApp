package pl.mmank.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mmank.todolist.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
