package com.bjpowernode.test;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.util.SqlSessionUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test2 {
    public static void main(String[] args) {
        StudentDao studentDao = SqlSessionUtil.getSession().getMapper(StudentDao.class);
        //测试：parameterType使用简单数据类型String
        /*Student s = studentDao.select1("A001");
        System.out.println(s);*/
        //测试：查询出所有年为27岁的学员的详细信息
        /*List<Student> sList = studentDao.select2(27);
        for(Student s:sList){
            System.out.println(s);
        }*/
        //测试：查询姓名为qx，年龄为27岁的学员信息
        // 如果我们要为sql语句传递多个参数，我们应该将这多个参数封装到一个domain对象中，或者是打包到一个map集合中
        //绝对不可以像下面的案例一样，同时为sql语句传递多个参数
        /*Student s = new Student();
        s.setName("qx");
        s.setAge(27);
        List<Student> sList = studentDao.select3(s);
        for(Student s1:sList){
            System.out.println(s1);}*/
        //测试：parameterType,使用map为参数
        /*Map<String,Object> map = new HashMap<String,Object>();
        map.put("name", "qx");
        map.put("age", 27);
        List<Student> sList = studentDao.select4(map);
        for(Student s1:sList){
            System.out.println(s1);}*/
        //测试：根据id查单条，sql使用${}来接收值
        /*Student s = studentDao.select5("A002");
        System.out.println(s);*/
        //测试：多表联查，查询出学生姓名和班级名称
        List<Map<String,Object>> mapList = studentDao.select6();
        for(Map<String,Object> map:mapList){
            Set<String> set = map.keySet();
            for(String key:set){
                System.out.println("key:" + key);
                System.out.println("value:" + map.get(key));
            }
        }

    }
}
