package net.therap.hibernet.service;

import net.therap.hibernet.dao.UserDao;
import net.therap.hibernet.domain.User;
import net.therap.hibernet.util.EntityManagerConfiguration;

import javax.persistence.EntityManager;
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

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findUserById(long id) {
        return userDao.findUserById(id);
    }

    public void save(long id, String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);

        userDao.save(user);
    }

    public void update(long id, String newName) {
        User user = entityManager.getReference(User.class, id);

        userDao.update(user, newName);
    }

    public void delete(long id) {
        userDao.delete(id);
    }
}