package com.mycclee.controller;

import com.mycclee.entity.Employee;
import com.mycclee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author mycclee
 * @createTime 2019/7/7 11:51
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/emps")
    public String list(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNumStr,
                       Map<String,Object> map){
        Integer pageNum = 1;
        try{
            //校验PageNum，如果参数出错了程序不至于死掉
            pageNum = new Integer(pageNumStr);
            if (pageNum < 1){
                pageNum = 1;
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        Page<Employee> page = employeeService.getPage(pageNum,5);
        map.put("page",page);
        return "emp/list";
    }
}
