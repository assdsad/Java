package org.example.avatartest.utils;

import cn.hutool.json.JSONUtil;

public class ResultUtils {

    //返回正确信息
    public static<T> String success(T data) {
        return success("注册成功", data);
    }
    public static<T> String success(String message, T data) {
        return success(200, message, data);
    }
    public static<T> String success(Integer code, String message, T data) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);

        return JSONUtil.toJsonStr(result);
    }

    //返回错误信息
    public static String error(String message) {
        return error(500, message);
    }
    public static String error(Integer code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return JSONUtil.toJsonStr(result);
    }

    public static String phoneExist(String message) {
        return phoneExist(409, message);
    }
    public static String phoneExist(Integer code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);

        return JSONUtil.toJsonStr(result);
    }
}
