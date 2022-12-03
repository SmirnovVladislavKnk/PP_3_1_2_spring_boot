package ru.vladislav_smirnov.spring_boot.dao;


import ru.vladislav_smirnov.spring_boot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void saveUsers(User user);
    User getUserById(Long id);
    void  deleteUserById(Long id);
    }
