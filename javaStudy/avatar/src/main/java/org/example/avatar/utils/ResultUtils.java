package org.example.avatar.utils;

import cn.hutool.json.JSONUtil;

public class ResultUtils {

    //返回正确信息
    public static<T> String registerSuccess(T data) {
        return registerSuccess("注册成功", data);
    }
    public static<T> String registerSuccess(String message, T data){
        return registerSuccess(200, message, data);
    }
    public static<T> String registerSuccess(Integer code, String message, T data) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);

        return JSONUtil.toJsonStr(result);
    }


    //返回错误信息
    public static String registerError(String message) {
        //code都为500，可以再次提炼
        return registerError(500, message);
    }
    public static String registerError(Integer code, String message){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return JSONUtil.toJsonStr(result);
    }

    public static String exist(String message){
        return exist(409, message);
    }
    public static String exist(Integer code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return JSONUtil.toJsonStr(result);
    }


    public static<T> String loginSuccess(T data) {
        return loginSuccess("注册成功", data);
    }
    public static<T> String loginSuccess(String message, T data){
        return loginSuccess(200, message, data);
    }
    public static<T> String loginSuccess(Integer code, String message, T data) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);

        return JSONUtil.toJsonStr(result);
    }

    public static String loginSuccess(String message) {
        return loginSuccess(301, message);
    }
    public static String loginSuccess(Integer code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return JSONUtil.toJsonStr(result);
    }

    public static String loginError(String message) {
        return loginError(302, message);
    }
    public static String loginError(Integer code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return JSONUtil.toJsonStr(result);
    }
}
