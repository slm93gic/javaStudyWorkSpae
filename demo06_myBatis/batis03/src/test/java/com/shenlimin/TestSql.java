package com.shenlimin;

import com.shenlimin.mapper.StudentMapper;
import com.shenlimin.pojo.Student;
import com.shenlimin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestSql {

    SqlSession session = MybatisUtils.getSqlSession();


    @Test
    public void testGetStudents() {
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        List<Student> students = mapper.getStudents2();

        for (Student student : students) {
            System.out.println("学生名:" + student.getName() + "\t老师:" + student.getTeacher().getName());
        }
    }
}
