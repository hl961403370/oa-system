package com.hl.oa.controller;

import com.hl.oa.biz.DepartmentBiz;
import com.hl.oa.biz.EmployeeBiz;
import com.hl.oa.entity.Department;
import com.hl.oa.entity.Employee;
import com.hl.oa.global.Contant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Map;

@Controller("employeeController")
@RequestMapping("/employee")
public class EmployeeController {

    @Resource(name = "departmentBiz")
    private DepartmentBiz departmentBiz;

    @Resource(name = "employeeBiz")
    private EmployeeBiz employeeBiz;

    @RequestMapping("/list")
    public String list(Map<String,Object> map){
        map.put("list",employeeBiz.getAll());
        return "employee_list";
    }

    @RequestMapping("/to_add")
    public String toAdd(Map<String,Object> map){
        map.put("employee",new Employee());
        map.put("dlist",departmentBiz.getAll());
        map.put("plist", Contant.getPosts());
        return "employee_add";
    }

    @RequestMapping("/add")
    public String add(Employee employee){
        employeeBiz.add(employee);
        return "redirect:list";
    }

    @RequestMapping(value = "/to_update",params = "sn")
    public String toUpdate(String sn,Map<String,Object> map){
        map.put("employee",employeeBiz.get(sn));
        return "employee_update";
    }

    @RequestMapping("/update")
    public String update(Employee employee){
        employeeBiz.edit(employee);
        return "redirect:list";
    }

    @RequestMapping(value = "/remove",params = "sn")
    public String toUpdate(String sn){
        employeeBiz.remove(sn);
        return "redirect:list";
    }

}
