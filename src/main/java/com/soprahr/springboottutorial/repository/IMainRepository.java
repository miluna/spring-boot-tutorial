package com.soprahr.springboottutorial.repository;

import com.soprahr.springboottutorial.model.User;

public interface IMainRepository {
    User selectUser(String id);
    User insertUser(User u);
}
