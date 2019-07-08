package com.mycclee.service;

import com.mycclee.entity.Employee;
import com.mycclee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author mycclee
 * @createTime 2019/7/7 11:48
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void save(Employee employee){
        if(null == employee.getId()){
            //设置创建时间
            employee.setCreateTime(new Date());
        }
        employeeRepository.saveAndFlush(employee);
    }

    @Transactional(readOnly = true)
    public Page<Employee> getPage(Integer pageNum,Integer pageSize){

        PageRequest pageRequest = PageRequest.of(pageNum - 1,pageSize);

        return employeeRepository.findAll(pageRequest);
    }

    @Transactional(readOnly = true)
    public Employee getByLastName(String lastName){
        return employeeRepository.getByLastName(lastName);
    }

    public Employee getEmployeeById(Integer id){
        return employeeRepository.getById(id);
    }

    @Transactional
    public void deleteEmployee(Integer id){
        employeeRepository.deleteById(id);
    }
}
