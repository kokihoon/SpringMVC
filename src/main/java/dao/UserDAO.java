package main.java.dao;

import org.springframework.stereotype.Repository;

import main.java.model.User;

@Repository
public interface UserDAO {
    // 세션에 등록
    public User get(User  user ) throws Exception;
}
