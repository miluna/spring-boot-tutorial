package com.soprahr.springboottutorial.service;

import com.soprahr.springboottutorial.model.User;

public interface IMainService {
    User getUser(String id) throws Exception;
    User createUser(User u) throws Exception;
}
