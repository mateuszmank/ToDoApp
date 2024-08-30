package pl.mmank.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mmank.todolist.model.UserEntity;
import pl.mmank.todolist.service.AchievementService;
import pl.mmank.todolist.model.Achievement;

import java.util.List;

@Controller
@RequestMapping("/achievements")
public class AchievementController {

    @Autowired
    private AchievementService achievementService;

    @GetMapping
    public String getAllAchievements(Model model) {                                   //metoda do popraia wszystkich osiagniec
        List achievements = achievementService.findAll();
        model.addAttribute("achievements", achievements);
        return "achievementList";  // Widok o nazwie "achievementList"
    }

    @GetMapping("/{id}")
    public String getAchievementById(@PathVariable Long id, Model model) {                       //pobieranie szczegółów konkretnego osiągnięcia
        Achievement achievement = achievementService.findById(id);
        if (achievement != null) {
            model.addAttribute("achievement", achievement);
            return "achievementDetail";  // Widok o nazwie "achievementDetail"
        } else {
            return "error";  // Widok błędu
        }
    }

    @GetMapping("/create")  // Wyświetlanie formularza do tworzenia
    public String createAchievementForm(Model model) {
        model.addAttribute("achievement", new Achievement());
        return "achievementForm";  // Widok o nazwie
    }


    @PostMapping("/create")
    public String createAchievement(@ModelAttribute Achievement achievement) {
        achievementService.save(achievement);
        return "redirect:/achievements";  // Przekierowanie po zapisaniu
    }

    @PostMapping("/delete/{id}")  // Usuwanie użytkownika
    public String deleteAchievements(@PathVariable Long id) {
        Achievement achievement = achievementService.findById(id);
        if (achievement != null) {
            achievementService.delete(achievement);
            return "redirect:/achievements";  // Przekierowanie po usunięciu
        } else {
            return "error";  // Widok błędu
        }
    }
}