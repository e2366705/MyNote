package com.example.demo.dao;

import com.example.demo.bean.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MajorDao extends JpaRepository<Major,Integer> {

    @Query("select m from Major m where m.major_id=?1")
    Major searchById(int id);

    @Query("select m from Major m where m.major_name=?1")
    Major searchByName(String name);
}
