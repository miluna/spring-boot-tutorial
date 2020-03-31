package com.soprahr.springboottutorial.service;

import com.soprahr.springboottutorial.exception.UserException;
import com.soprahr.springboottutorial.model.User;
import com.soprahr.springboottutorial.repository.IMainRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainServiceImpl implements IMainService {

    private IMainRepository repository;

    public MainServiceImpl(@Autowired IMainRepository r) {
        this.repository = r;
    }

    @Override
    public List<User> getAllUsers() throws Exception {
        return repository.selectAllUsers();
    }

    @Override
    public User getUser(@NonNull String id) throws Exception {
        if (id.equals("")) throw new Exception("Invalid user ID provided");
         return repository.selectUser(id);
    }

    @Override
    public User createUser(User u) throws Exception {
        String dateRegex = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (u.getBirthDate().matches(dateRegex)) {
            if (u.getEmail().matches(emailRegex)) {
                return repository.insertUser(u);
            } else throw new UserException("Invalid email format");
        } else throw new UserException("Invalid birth date");
    }
}
