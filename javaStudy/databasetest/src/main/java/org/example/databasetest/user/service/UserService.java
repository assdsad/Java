package org.example.databasetest.user.service;

import org.example.databasetest.user.dao.UserDao;

public class UserService {
    public boolean login(String email, String name) {
        return new UserDao().findByEmailAndName(email, name);
    }

    public void findAllInDb(){
        new UserDao().findAll();
    }
}
