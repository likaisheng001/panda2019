package com.panda.controller;

import com.panda.bean.Department;
import com.panda.bean.Employee;
import com.panda.mapper.DepartmentMapper;
import com.panda.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id")Integer id){
        return departmentMapper.getDeptById(id);
    }
    @GetMapping("/dept")
    public Department insertDept(Department department){
        departmentMapper.insertDept(department);
        return department;
    }

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id")Integer id){
        return employeeMapper.getEmpById(id);
    }
}
