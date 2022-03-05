package com.mman.meeting.service;

import com.mman.meeting.mapper.EmployeeMapper;
import com.mman.meeting.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 莫曼
 * @version 1.0
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public Employee doLogin(String username, String password) {
        Employee employee = employeeMapper.loadEmpByUserName(username);
        if (employee == null || !employee.getPassword().equals(password)) {
            return null;
        }
        return employee;
    }

    public Integer doReg(Employee employee) {
        Employee emp = employeeMapper.loadEmpByUserName(employee.getUsername());
        if (emp != null) {
            return -1;
        }
        employee.setRole(1);
        employee.setStatus(0);
        return employeeMapper.doReg(employee);
    }

    public List<Employee> getAllEmpsByStatus(Integer status) {
        return employeeMapper.getAllEmpsByStatus(status);
    }

    public Integer updatestatus(Integer employeeid, Integer status) {
        return employeeMapper.approveaccount(employeeid, status);
    }

    public List<Employee> getAllEmps(Employee employee, Integer page, Integer pageSize) {
        //这个page是从第几行数据开始查
        page = (page - 1) * pageSize;
        return employeeMapper.getAllEmps(employee, page, pageSize);
    }

    public long getTotal(Employee employee) {
        return employeeMapper.getTotal(employee);
    }

    public List<Employee> getEmpsByDepId(Integer depId) {
        return employeeMapper.getEmpsByDepId(depId);
    }
}
