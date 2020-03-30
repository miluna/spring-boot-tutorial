package com.soprahr.springboottutorial.controller;

import com.soprahr.springboottutorial.model.User;
import org.springframework.http.ResponseEntity;

public interface IMainController {
    ResponseEntity<User> postUser(User u) throws Exception;
    ResponseEntity<User> getUser(String id) throws Exception;
}
