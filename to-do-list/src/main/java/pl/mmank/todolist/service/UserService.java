package pl.mmank.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mmank.todolist.repository.UserRepository;
import pl.mmank.todolist.model.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List findAll() {
        return userRepository.findAll();                    //zwraca wszyskich uzytkowników
    }

    public User save(User user) {
        return  userRepository.save(user);                            //zapisuje usera w bazie danych
    }

    public User findById(Long id) {
        return  userRepository.findById(id).orElse(null);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
}
