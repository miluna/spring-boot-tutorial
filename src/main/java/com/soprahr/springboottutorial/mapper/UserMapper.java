package com.soprahr.springboottutorial.mapper;

import com.soprahr.springboottutorial.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User u = new User();
        u.setId(resultSet.getString("id"));
        u.setName(resultSet.getString("name"));
        u.setEmail(resultSet.getString("email"));
        u.setBirthDate(resultSet.getString("birth_date"));
        return u;
    }
}
