package com.example.demo.service.impl;

import com.example.demo.bean.Major;
import com.example.demo.dao.MajorDao;
import com.example.demo.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MajorImpl implements MajorService {
    @Autowired
    MajorDao majorDao;

    @Override
    public Major searchByName(String major_name) {
        return majorDao.searchByName(major_name);
    }

    @Override
    public Major searchById(Integer major_id) {
        return majorDao.searchById(major_id);
    }

    @Override
    public void insert(String major_name) {
        majorDao.save(new Major(major_name));
    }

    @Override
    public void deleteByName(String major_name) {
        majorDao.delete(majorDao.searchByName(major_name));
    }

    @Override
    public List<Major> findAll() {
        return majorDao.findAll();
    }
}
