package com.mycclee.controller;

import com.mycclee.entity.Employee;
import com.mycclee.service.DepartmentService;
import com.mycclee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author mycclee
 * @createTime 2019/7/7 11:51
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

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
        System.out.println(page.getNumberOfElements());
        if (page == null || page.getNumberOfElements() == 0){
            page = null;
        }
        map.put("info",page);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String input(Map<String,Object> map){
        map.put("departments",departmentService.getAll());
        map.put("employee",new Employee());
        return "emp/input";
    }

    /**
     *
     * @param lastName
     * @return 如果可用返回0，不可用则返回1
     */
    @PostMapping(value = "/ajaxValidateLastName")
    @ResponseBody
    public String validateLastName(@RequestParam(value = "lastName",required = true) String lastName){
        Employee employee = employeeService.getByLastName(lastName);
        if (employee == null){
            return "0";
        }
        return "1";
    }

    @PostMapping("/emp")
    public String save(Employee employee){
        employeeService.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String input(@PathVariable("id") Integer id,Map<String,Object> map){
        Employee employee = employeeService.getEmployeeById(id);
        map.put("employee",employee);
        map.put("departments",departmentService.getAll());
        return "emp/input";
    }

    @PutMapping("/emp/{id}")
    public String update(Employee employee){
        employeeService.save(employee);
        return "redirect:/emps";
    }

    @ModelAttribute
    public void getEmployee(@RequestParam(value = "id",required = false) Integer id,Map<String,Object> map){
        if (null != id){
            Employee employee = employeeService.getEmployeeById(id);
            employee.setDepartment(null);
            map.put("employee",employee);
        }
    }
}
