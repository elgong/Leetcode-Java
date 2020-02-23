package top.elgong.reflect.impl;

import top.elgong.reflect.IUser;

/**
 *  user类的实现
 */
public class UserImpl implements IUser {
    // 内部变量
    private String name;
    private Integer age;

    private static String log = "user 类";

    // 构造函数
    public UserImpl(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public UserImpl(){

    }

    // set 和 get
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public void printLog() {
        System.out.println("haha");

    }

    @Override
    public String toString() {
        return "UserImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
