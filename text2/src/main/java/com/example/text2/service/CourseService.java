package com.example.text2.service;

import com.example.text2.dao.CourseDao;
import com.example.text2.dao.UserDao;
import com.example.text2.pojo.Course;
import com.example.text2.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseDao courseDao;
    public List<Course> getAllCourses(){
        return courseDao.getAll();

    }
    public int add(Course course){
    return courseDao.addCourse(course);
    }
    public int update(Course course){
        return courseDao.updateCourse(course);
    }
    public int  deleteById(int id){
        return courseDao.deleteCourseById(id);
    }
    public  Course getById(int id){
        return courseDao.getCourseById(id);
    }
}
