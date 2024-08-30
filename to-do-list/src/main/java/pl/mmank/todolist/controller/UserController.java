package pl.mmank.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mmank.todolist.service.UserService;
import pl.mmank.todolist.model.User;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllUsers(Model model) {                                   //pobieranie all użytkowników
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "userList";  // Widok o nazwie "userList"
    }

    @GetMapping("/{id}")                                                        //pobieranie użytkownika po ID
    public String getUserById(@PathVariable Long id, Model model) {
        User user = (User) userService.findById(id);
        if (user != null) {
            model.addAttribute("user", user);
            return "userProfile";  // Widok o nazwie "userProfile"
        } else {
            return "error";  // Widok błędu
        }
    }

    @GetMapping("/create")  // Wyświetlanie formularza do tworzenia nowego użytkownika
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "userForm";  // Widok o nazwie "userForm"
    }

    @PostMapping("/create")                                             //tworzenie nowego użytkownika
    public String createUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/users";  // Przekierowanie po zapisaniu
    }

    @PutMapping("/{id}")                                  //aktualizacja użytkownika
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User existingUser = (User) userService.findById(id);
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setLevel(user.getLevel());
            existingUser.setXp(user.getXp());
            userService.save(existingUser);
            return ResponseEntity.ok(existingUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")                              //usuwanie
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        User user = (User) userService.findById(id);
        if (user != null) {
            userService.delete(user);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
