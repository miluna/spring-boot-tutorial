package com.soprahr.springboottutorial.controller;

import com.soprahr.springboottutorial.model.User;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface IMainController {
    ResponseEntity<User> postUser(User u) throws Exception;
    ResponseEntity<User> getUser(String id) throws Exception;
    ResponseEntity<List<User>> getAllUsers() throws Exception;
}
