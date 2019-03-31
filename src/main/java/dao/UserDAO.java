package main.java.dao;
import main.java.model.User;

public interface UserDAO {
    // 세션에 등록
    public User login(User  user ) throws Exception;
}
