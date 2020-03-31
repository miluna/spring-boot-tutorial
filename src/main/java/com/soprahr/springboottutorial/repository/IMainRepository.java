package com.soprahr.springboottutorial.repository;

import com.soprahr.springboottutorial.model.User;
import java.util.List;

public interface IMainRepository {
    List<User> selectAllUsers();
    User selectUser(String id);
    User insertUser(User u);
}
