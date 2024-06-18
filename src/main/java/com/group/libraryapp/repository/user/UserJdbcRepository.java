package com.group.libraryapp.repository.user;

import com.group.libraryapp.dto.User.response.UserResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserJdbcRepository {
    private final JdbcTemplate jdbcTemplate;
    public UserJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public boolean isUserNotExist(long id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> 0, id).isEmpty();
    }
    public void updateUserName(String name, long id) {
        String sql = "UPDATE user SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, name, id);
    }
    public boolean isUserExist(String name) {
        String readSql = "SELECT * FROM user WHERE name = ?";
        return jdbcTemplate.query(readSql,(rs, rowNum) ->0,name).isEmpty();
    }
    public void deleteUser(String name) {
        String sql = "DElETE FROM user WHERE name = ?";
        jdbcTemplate.update(sql,name);
    }
    public void saveUser(String name ,Integer age){
        String sql = "INSERT INTO user(name, age) VALUES(?, ?)";
        jdbcTemplate.update(sql, name, age);
    }
    public List<UserResponse> getUsers(){
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql,(rs,rowNum)-> {
            long id = rs.getLong("id");
            String name = rs.getString("id") ;
            int age = rs.getInt("age");
            return new UserResponse(id, name, age);
        });
    }
}