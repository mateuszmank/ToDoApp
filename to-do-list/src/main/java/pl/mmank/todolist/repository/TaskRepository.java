package pl.mmank.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mmank.todolist.model.Task;
import pl.mmank.todolist.model.UserEntity;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByUserEntity(UserEntity userEntity);

}
