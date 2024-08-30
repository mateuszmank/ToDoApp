package pl.mmank.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.mmank.todolist.model.UserEntity;
import pl.mmank.todolist.service.TaskService;
import pl.mmank.todolist.model.Task;

import javax.validation.Valid;


@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public String getAllTasks(Model model) {                                           //pobieranie zadań
        model.addAttribute("tasks", taskService.findAllTasksByActiveUser());
        return "taskList";
    }

    @GetMapping("/{id}")                                                        //pobieranie użytkownika po ID
    public String getTaskById(@PathVariable Long id, Model model) {
        Task task = (Task) taskService.findById(id);
        if (task != null) {
            model.addAttribute("task", task);
            return "taskProfile";  // Widok o nazwie "taskProfile"
        } else {
            return "error";  // Widok błędu
        }
    }

    @GetMapping("/create")                                       //formularz do tworzenia
    public String createTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "taskForm";
    }

    @PostMapping("/create")                                 // tworzenie zadania
    public String createTask(@Valid @ModelAttribute("task") Task task, BindingResult result) {
        if (result.hasErrors()) {
            return "taskForm";
        }
        taskService.save(task);
        return "redirect:/tasks";
    }


    @GetMapping("/edit/{id}")                // formularz do  edycja zadania
    public String editTaskForm(@PathVariable("id") Long id, Model model) {
        Task task = taskService.findById(id);
        if (task == null) {
            return "redirect:/tasks";
        }
        model.addAttribute("task", task);
        return "taskForm";
    }

    @PostMapping("/edit/{id}")                       // edycja zadania
    public String editTask(@PathVariable("id") Long id, @Valid @ModelAttribute("task") Task task, BindingResult result) {
        if (result.hasErrors()) {
            return "taskForm";
        }
        taskService.save(task);
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")                              //usunięcie
    public String deleteTask(@PathVariable("id") Long id) {
        taskService.deleteById(id);
        return "redirect:/tasks";
    }
}