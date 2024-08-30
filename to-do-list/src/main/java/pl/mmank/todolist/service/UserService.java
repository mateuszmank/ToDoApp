package pl.mmank.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.mmank.todolist.repository.UserRepository;
import pl.mmank.todolist.model.UserEntity;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List findAll() {
        return userRepository.findAll();                    //zwraca wszyskich uzytkowników
    }

    public UserEntity save(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        return  userRepository.save(user);                            //zapisuje usera w bazie danych
    }

    public UserEntity findById(Long id) {
        return  userRepository.findById(id).orElse(null);
    }


    public void delete(UserEntity userEntity) {
        userRepository.delete(userEntity);
    }

    public UserEntity findByUserName(String name) {
        return userRepository.findByUsername(name).get();
    }
}
