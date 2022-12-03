package ru.vladislav_smirnov.spring_boot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.vladislav_smirnov.spring_boot.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = em.createQuery("FROM User", User.class).getResultList();
        return allUsers;
    }

    @Override
    public void saveUsers(User user) {
        this.em.merge(user);
    }

    @Override
    public User getUserById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public void deleteUserById(Long id) {
        User user = em.find(User.class, id);
        this.em.remove(user);
    }

}
