package pl.mmank.todolist.model;


import javax.persistence.*;

import java.time.LocalDateTime;


@Entity
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToOne
    @JoinColumn(name = "task_id")
    private Task task;

    private LocalDateTime dateEarned;

    // Konstruktor domyślny
    public Achievement() {}

    // Konstruktor z parametrami
    public Achievement(UserEntity userEntity, String name, String description, LocalDateTime dateEarned) {
        this.task = task;
        this.name = name;
        this.description = description;
        this.dateEarned = dateEarned;
    }

    // Gettery i Settery

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateEarned() {
        return dateEarned;
    }

    public void setDateEarned(LocalDateTime dateEarned) {
        this.dateEarned = dateEarned;
    }
}
