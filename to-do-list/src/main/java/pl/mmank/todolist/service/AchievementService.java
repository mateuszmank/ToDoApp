package pl.mmank.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mmank.todolist.repository.AchievementRepository;
import pl.mmank.todolist.model.Achievement;

import java.util.List;

@Service
public class AchievementService {

    @Autowired
    private AchievementRepository achievementRepository;

    public List findAll() {
        return achievementRepository.findAll();
    }          // zwraca liste wszystkich osiągnięc

    public Achievement save(Achievement achievement) {
        return (Achievement) achievementRepository.save(achievement);
    }

    public Achievement findById(Long id) {
        return (Achievement) achievementRepository.findById(id).orElse(null);
    }

    public void delete(Achievement user) {
        achievementRepository.delete(user);
    }
}
