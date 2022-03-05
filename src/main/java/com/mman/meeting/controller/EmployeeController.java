package com.mman.meeting.controller;

import com.mman.meeting.model.Employee;
import com.mman.meeting.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 莫曼
 * @version 1.0
 */
@Controller
@RequestMapping("/admin")
public class EmployeeController {

    public static final Integer PAGE_SIZE = 10;

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/searchemployees")
    public String getAllEmployees(Employee employee, @RequestParam(defaultValue = "1") Integer page, Model model) {
        List<Employee> emps = employeeService.getAllEmps(employee, page, PAGE_SIZE);
        long total = employeeService.getTotal(employee);
        model.addAttribute("emps", emps);
        model.addAttribute("total", total);
        model.addAttribute("page", page);
        model.addAttribute("pagenum", total % PAGE_SIZE == 0? total / PAGE_SIZE : total / PAGE_SIZE + 1);
        return "searchemployees";
    }

    @RequestMapping("/updateemp")
    public String updateemp(Integer id) {
        employeeService.updatestatus(id, 2);
        return "redirect:/admin/searchemployees?status=1";
    }
}
