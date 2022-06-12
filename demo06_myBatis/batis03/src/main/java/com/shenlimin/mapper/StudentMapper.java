package com.shenlimin.mapper;

import com.shenlimin.pojo.Student;
import com.shenlimin.pojo.Teacher;

import java.util.List;

public interface StudentMapper {

    //获取所有学生及对应老师的信息
    public List<Student> getStudents();


    public List<Student> getStudents2();

    //获取指定老师，及老师下的所有学生
    public Teacher getTeacher(int id);


}
