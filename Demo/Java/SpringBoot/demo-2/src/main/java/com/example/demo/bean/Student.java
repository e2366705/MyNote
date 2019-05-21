package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stu_id;
    private String stu_name;
    private String gender;
    private int m_id;

    public Student(){}

    public Student(int stu_id,String stu_name,String gender,int m_id){
        this.stu_id = stu_id;
        this.stu_name = stu_name;
        this.gender = gender;
        this.m_id = m_id;
    }

    public Student(String name, String gender, Integer m_id) {
        this.stu_name = stu_name;
        this.gender = gender;
        this.m_id = m_id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }
}
