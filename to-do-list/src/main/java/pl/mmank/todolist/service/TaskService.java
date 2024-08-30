package pl.mmank.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mmank.todolist.repository.TaskRepository;
import pl.mmank.todolist.model.Task;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();                                           //zwraca liste wszystkich zdan
    }

    public Task save(Task task) {
        return  taskRepository.save(task);
    }

    public Task findById(Long id) {
        return  taskRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
}
