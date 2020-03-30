package com.soprahr.springboottutorial.controller;

import com.soprahr.springboottutorial.model.ErrorMessage;
import com.soprahr.springboottutorial.model.User;
import com.soprahr.springboottutorial.service.IMainService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@ControllerAdvice
public class MainController implements IMainController {

    private IMainService service;

    public MainController(@Autowired IMainService s) {
        this.service = s;
    }

    @PostMapping(value = "users")
    @Override
    public ResponseEntity<User> postUser(@RequestBody @NonNull User u) throws Exception {
        if (StringUtils.isEmpty(u.getName()) || StringUtils.isEmpty(u.getEmail())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        User newUser = service.createUser(u);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping(value = "users/{id}")
    @Override
    public ResponseEntity<User> getUser(@PathVariable @NonNull String id) throws Exception {
        User user = service.getUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> exceptionHandler(Exception e) {
        return new ResponseEntity<>(
                new ErrorMessage(HttpStatus.BAD_REQUEST.value(), e.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

}
