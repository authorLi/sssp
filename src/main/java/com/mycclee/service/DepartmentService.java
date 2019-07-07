package com.mycclee.service;

import com.mycclee.entity.Department;
import com.mycclee.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author mycclee
 * @createTime 2019/7/7 17:07
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public List<Department> getAll(){
        return departmentRepository.getAll();
    }
}
