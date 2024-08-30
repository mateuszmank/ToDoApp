package pl.mmank.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mmank.todolist.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}