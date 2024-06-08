package com.cake.caketest.cake.comment.service;

import com.cake.caketest.cake.comment.dao.CommentDao;
import com.cake.caketest.user.userdao.UserDao;

public class CommentService {
    public void addComment(String id , String content, String email) {
        new CommentDao().saveComment(content, email, id);
        new UserDao().updateScore(email, 10);
    }
}
