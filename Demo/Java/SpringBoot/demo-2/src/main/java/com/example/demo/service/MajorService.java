package com.example.demo.service;

import com.example.demo.bean.Major;
import java.util.List;

public interface MajorService {
    //根据专业名查找
    Major searchByName(String major_name);
    //根据id查找
    Major searchById(Integer major_id);
    //根据专业名添加
    void insert(String major_name);
    //根据专业名删除
    void deleteByName(String major_name);
    //查询所有
    List<Major> findAll();
}
