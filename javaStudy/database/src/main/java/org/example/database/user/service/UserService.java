package org.example.database.user.service;

import org.example.database.user.dao.UserDao;

public class UserService {

    public boolean login(String email, String name) {

        return new UserDao().findByEmailAndName(email, name);
    }
}
