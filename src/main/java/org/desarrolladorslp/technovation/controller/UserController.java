package org.desarrolladorslp.technovation.controller;

import java.util.List;

import org.desarrolladorslp.technovation.models.User;
import org.desarrolladorslp.technovation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    private UserService userService;

    @Secured("ROLE_ADMINISTRATOR")
    @GetMapping("/inactive")
    public ResponseEntity<List<User>> listInvalidUsers() {
        return new ResponseEntity<>(userService.findByValidated(false), HttpStatus.OK);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
