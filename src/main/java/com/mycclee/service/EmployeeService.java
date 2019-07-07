package com.mycclee.service;

import com.mycclee.entity.Employee;
import com.mycclee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author mycclee
 * @createTime 2019/7/7 11:48
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public Page<Employee> getPage(Integer pageNum,Integer pageSize){

        PageRequest pageRequest = new PageRequest(pageNum - 1,pageSize);

        return employeeRepository.findAll(pageRequest);
    }
}
