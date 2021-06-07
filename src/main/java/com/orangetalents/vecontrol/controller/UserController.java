package com.orangetalents.vecontrol.controller;

import com.orangetalents.vecontrol.dto.UserDto;
import com.orangetalents.vecontrol.model.User;
import com.orangetalents.vecontrol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody @Validated UserDto userDto) {
        User user = User.toEntity(userDto);
        return new ResponseEntity<>(
                userService.save(user),
                getAllowOriginHeaders(),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<>(userService.findAll(), getAllowOriginHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> findById(@PathVariable Long userId) {
        User user = userService.findById(userId);
        return new ResponseEntity<>(user, getAllowOriginHeaders(), HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> update(@PathVariable Long userId, @RequestBody UserDto userDto) {
        User userUpdated = userService.update(userId, userDto);
        return new ResponseEntity<>(userUpdated, getAllowOriginHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable Long userId) {
        userService.delete(userId);
    }

    private HttpHeaders getAllowOriginHeaders() {
        return new HttpHeaders();
    }
}
