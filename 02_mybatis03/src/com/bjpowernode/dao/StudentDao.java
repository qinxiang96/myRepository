package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    public Student getById(String id);
    public void save(Student s);

    List<Student> getAll();

    Student select1(String a001);

    List<Student> select2(int i);

    List<Student> select3(Student s);

    List<Student> select4(Map<String, Object> map);

    Student select5(String a002);

    List<Map<String, Object>> select6();
}
