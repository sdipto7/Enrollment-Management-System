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

    public List<User> getUsers() {
        return userDao.getAll();
    }

    public void addUser(int id, String name) {
        userDao.add(id, name);
    }

    public void updateUser(int id, String newName){
        userDao.update(id,newName);
    }

    public void deleteUser(int id){
        userDao.delete(id);
    }

}
