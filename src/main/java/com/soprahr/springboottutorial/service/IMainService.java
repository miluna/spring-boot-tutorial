package com.soprahr.springboottutorial.service;

import com.soprahr.springboottutorial.model.User;
import java.util.List;

public interface IMainService {
    List<User> getAllUsers() throws Exception;
    User getUser(String id) throws Exception;
    User createUser(User u) throws Exception;
}
