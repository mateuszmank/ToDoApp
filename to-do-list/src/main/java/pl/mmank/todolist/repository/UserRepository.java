package pl.mmank.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mmank.todolist.model.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);
}