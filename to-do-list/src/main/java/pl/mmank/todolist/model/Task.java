package pl.mmank.todolist.model;


import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userEntity_id", nullable = false)
    private UserEntity userEntity;

    @NotBlank
    private String title;

    private String description;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @NumberFormat
    private int points;

    private boolean status;

    // Konstruktor domyślny
    public Task() {}

    // Konstruktor z parametrami
    public Task(UserEntity userEntity, String title, String description, Difficulty difficulty, int points, boolean status) {
        this.userEntity = userEntity;
        this.title = title;
        this.description = description;
        this.difficulty = difficulty;
        this.points = points;
        this.status = status;
    }

    // Gettery i Settery



    public UserEntity getUser() {
        return userEntity;
    }

    public void setUser(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    // Enum dla poziomu trudności
    public enum Difficulty {                     // typ wyliczany, który reprezentuje poziom trudności zadania.
        EASY, MEDIUM, HARD
    }
}
