package com.orangetalents.vecontrol.service;

import com.orangetalents.vecontrol.dto.UserDto;
import com.orangetalents.vecontrol.model.User;
import com.orangetalents.vecontrol.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    public static final String USER_NOT_FOUND = "User not found";

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        if (documentExists(user)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User Already Exists");
        } else {
            if (emailExists(user)) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Email Already Exists");
            } else {
                user.setVehicles(null);
                return userRepository.save(user);
            }
        }
    }

    public User findById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, USER_NOT_FOUND));
    }

    public User update(Long userId, UserDto userDto) {
        return userRepository.findById(userId)
                .map(user -> {
                    user.setName(userDto.getName());
                    user.setEmail(userDto.getEmail());
                    user.setDocument(userDto.getDocument());
                    return userRepository.save(user);
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, USER_NOT_FOUND));
    }

    public void delete(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, USER_NOT_FOUND);
        }
    }

    private boolean emailExists(User user) {
        return userRepository.findByEmail(user.getEmail()).isPresent();
    }

    private boolean documentExists(User user) {
        return userRepository.findByDocument(user.getDocument()).isPresent();
    }
}
