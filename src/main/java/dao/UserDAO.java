package main.java.dao;

import org.springframework.stereotype.Repository;

import main.java.model.User;

@Repository
public interface UserDAO {
    // ���ǿ� ���
    public User get(User  user ) throws Exception;
}
