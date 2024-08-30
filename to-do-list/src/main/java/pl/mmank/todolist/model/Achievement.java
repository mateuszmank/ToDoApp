package pl.mmank.todolist.model;


import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Achievement {

    @Id                                                                         // Wskazuje, że pole id jest kluczem głównym encji, czyli unikalnym identyfikatorem rekordu w tabeli bazy danych.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String name;
    private String description;
    private LocalDateTime dateEarned;

    // Konstruktor domyślny
    public Achievement() {}

    // Konstruktor z parametrami
    public Achievement(User user, String name, String description, LocalDateTime dateEarned) {
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
