package com.zh.SpringBootDemo.service;

public interface UserService {

	/**
     * 新增一个用户
     * @param name
     * @param age
     */
    void create(String name, Integer age);

    /**
     * 根据name删除一个用户高
     * @param name
     */
    void deleteByName(String name);

    /**
     * 获取用户总量
     */
    Integer getUserCount();

    /**
     * 删除所有用户
     */
    void deleteAllUsers();

	Integer getUserCount2();
}
