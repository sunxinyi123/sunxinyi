package com.example.text2.dao;

import com.example.text2.pojo.Course;
import com.example.text2.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Course> getAll(){
        return jdbcTemplate.query("select *from course ",new BeanPropertyRowMapper<>(Course.class));
    }

    public  int addCourse(Course course){
        return jdbcTemplate.update("INSERT INTO course(courseName,teacherName) VALUES (?,?)",course.getCourseName(),course.getTeacherName());
    }

    public  int updateCourse(Course course){
        return jdbcTemplate.update("UPDATE course SET courseName=?,teacherName=?",course.getCourseName(),course.getTeacherName());
    }
    public  int deleteCourseById(int id){
        return jdbcTemplate.update("DELETE FROM course WHERE id=?",id);


    }
    public  Course getCourseById (int  id){
        return jdbcTemplate.queryForObject("select * from course where id=?",
                new BeanPropertyRowMapper<>(Course.class),id);


    }
}
