package com.soprahr.springboottutorial.repository;

import com.soprahr.springboottutorial.mapper.UserMapper;
import com.soprahr.springboottutorial.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MainRepositoryImpl implements IMainRepository {

    private JdbcTemplate template;
    private SimpleJdbcInsert insert;

    public MainRepositoryImpl(@Autowired JdbcTemplate j, @Autowired SimpleJdbcInsert i) {
        this.template = j;
        this.insert = i;
    }

    @Override
    public User selectUser(String id) {
        String sql = "SELECT * FROM USUARIOS WHERE id=?";
        return template.queryForObject(sql,new Object[] {id}, new UserMapper());
    }

    @Override
    public User insertUser(User u) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", u.getName());
        params.put("email", u.getEmail());
        params.put("birth_date", u.getBirthDate());

        Number insertedId = insert
                .withTableName("USUARIOS")
                .usingGeneratedKeyColumns("id")
                .executeAndReturnKey(params);

        User newUser = new User();
        newUser.setId(insertedId.toString());
        return newUser;
    }
}
