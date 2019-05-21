package com.example.demo.dao;

import com.example.demo.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentDao extends JpaRepository<Student,Integer> {
    @Query("select s from Student s where s.stu_name=?1")
    Student searchByName(String name);

    @Query("select s from Student s where s.stu_id=?1")
    Student searchById(int id);
}
