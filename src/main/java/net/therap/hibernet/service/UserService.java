package net.therap.hibernet.service;

import net.therap.hibernet.dao.UserDao;
import net.therap.hibernet.domain.User;

import java.util.List;

/**
 * @author rumi.dipto
 * @since 8/25/21
 */
public class UserService {

    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User find(long id) {
        return userDao.find(id);
    }

    public void saveOrUpdate(User user) {
        userDao.saveOrUpdate(user);
    }

    public void delete(long id) {
        userDao.delete(id);
    }
}