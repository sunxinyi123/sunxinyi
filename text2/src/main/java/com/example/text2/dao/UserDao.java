package com.example.text2.dao;

import com.example.text2.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<User> getAll(){
        return jdbcTemplate.query("select *from user ",new BeanPropertyRowMapper<>(User.class));
    }


    // 添加
    public  int addUser(User user){
        return jdbcTemplate.update("INSERT INTO user(name,password,classNo,sex) VALUES (?,?,?,?)",user.getName(),user.getPassword(),user.getClassNo(),user.getSex());
    }
    //修改
    public  int updateUser(User user){
        return jdbcTemplate.update("UPDATE user SET name=?,password=?,classNo=?,sex=? WHERE id=?",user.getName(),user.getPassword(),user.getClassNo(),user.getSex());
    }
    //删除
    public  int deleteUserById(int id){
        return jdbcTemplate.update("DELETE FROM user WHERE id=?",id);


    }
    //根据ID去查询对应学生的信息
    public  User getUserById (int  id){
        return jdbcTemplate.queryForObject("select * from user where id=?",
                new BeanPropertyRowMapper<>(User.class),id);


    }



}
