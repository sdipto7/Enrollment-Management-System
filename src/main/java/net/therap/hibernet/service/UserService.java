package net.therap.hibernet.service;

import net.therap.hibernet.dao.UserDao;
import net.therap.hibernet.domain.User;

import javax.persistence.Query;
import java.util.List;

import static net.therap.hibernet.util.EntityManagerConfiguration.entityManager;

/**
 * @author rumi.dipto
 * @since 8/25/21
 */
public class UserService {

    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public List<User> getUserList() {
        Query query = entityManager.createQuery("from User");

        return userDao.getAll(query);
    }

    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    public void addUser(int id, String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);

        userDao.add(user);
    }

    public void updateUser(int id, String newName) {
        User user = entityManager.find(User.class, id);

        userDao.update(user, newName);
    }

    public void deleteUser(int id) {
        User user = entityManager.find(User.class, id);

        userDao.delete(user);
    }
}