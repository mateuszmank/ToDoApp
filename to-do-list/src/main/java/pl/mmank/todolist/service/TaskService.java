package pl.mmank.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pl.mmank.todolist.model.UserEntity;
import pl.mmank.todolist.repository.TaskRepository;
import pl.mmank.todolist.model.Task;
import pl.mmank.todolist.repository.UserRepository;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();                                           //zwraca liste wszystkich zdan
    }

    public List<Task> findAllTasksByActiveUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();
        UserEntity userEntity = userRepository.findByUsername(username).get();
        return taskRepository.findAllByUserEntity(userEntity);
    }

    public Task save(Task task) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();
        task.setUser(userRepository.findByUsername(username).get());
        return  taskRepository.save(task);
    }

    public Task findById(Long id) {
        return  taskRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
}
