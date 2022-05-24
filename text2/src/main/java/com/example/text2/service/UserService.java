package com.example.text2.service;

import com.example.text2.dao.UserDao;
import com.example.text2.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//服务纯粹就是调用dao里面的方法
@Service
public class UserService {
    @Autowired

    private UserDao userDao;
    public List<User> getAllUsers(){
        return userDao.getAll();

    }
    public int add(User user){
        return userDao.addUser(user);
    }
    public int update(User user){
        return userDao.updateUser(user);
    }
    public int  deleteById(int id){//根据ID号删除
        return userDao.deleteUserById(id);

    }
    public  User  getById(int id){
        return userDao.getUserById(id);//根据id号来查询
    }

}

