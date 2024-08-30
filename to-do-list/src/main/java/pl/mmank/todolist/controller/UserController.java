package pl.mmank.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mmank.todolist.service.UserService;
import pl.mmank.todolist.model.UserEntity;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllUsers(Model model) {                                   //pobieranie all użytkowników
        List<UserEntity> userEntities = userService.findAll();
        model.addAttribute("users", userEntities);
        return "userList";  // Widok o nazwie "userList"
    }

    @GetMapping("/{id}")                                                        //pobieranie użytkownika po ID
    public String getUserById(@PathVariable Long id, Model model) {
        UserEntity userEntity = (UserEntity) userService.findById(id);
        if (userEntity != null) {
            model.addAttribute("user", userEntity);
            return "userProfile";  // Widok o nazwie "userProfile"
        } else {
            return "error";  // Widok błędu
        }
    }

    @GetMapping("/create")  // Wyświetlanie formularza do tworzenia nowego użytkownika
    public String createUserForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "userForm";  // Widok o nazwie "userForm"
    }

    @PostMapping("/create")                                             //tworzenie nowego użytkownika
    public String createUser(@ModelAttribute UserEntity userEntity) {
        userService.save(userEntity);
        return "redirect:/users";  // Przekierowanie po zapisaniu
    }


    @PostMapping("/delete/{id}")  // Usuwanie użytkownika
    public String deleteUser(@PathVariable Long id) {
        UserEntity userEntity = userService.findById(id);
        if (userEntity != null) {
            userService.delete(userEntity);
            return "redirect:/users";  // Przekierowanie po usunięciu
        } else {
            return "error";  // Widok błędu
        }
    }
}
