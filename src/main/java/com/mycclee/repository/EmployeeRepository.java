package com.mycclee.repository;

import com.mycclee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author mycclee
 * @createTime 2019/7/7 11:47
 */
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {


}
