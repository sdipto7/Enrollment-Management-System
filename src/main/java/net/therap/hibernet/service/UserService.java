package net.therap.hibernet.service;

import net.therap.hibernet.dao.UserDao;
import net.therap.hibernet.domain.User;
import net.therap.hibernet.util.EntityManagerConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author rumi.dipto
 * @since 8/25/21
 */
public class UserService {

    EntityManager entityManager = EntityManagerConfiguration.getInstance().getEntityManager();

    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public List<User> getUserList() {
        return userDao.findAll();
    }

    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }

    public void addUser(long id, String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);

        userDao.add(user);
    }

    public void updateUser(long id, String newName) {
        User user = entityManager.find(User.class, id);

        userDao.update(user, newName);
    }

    public void deleteUser(long id) {
        userDao.delete(id);
    }
}