package com.mman.meeting.mapper;

import com.mman.meeting.model.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 莫曼
 * @version 1.0
 */
public interface EmployeeMapper {
    Employee loadEmpByUserName(String username);

    Integer doReg(Employee employee);

    List<Employee> getAllEmpsByStatus(Integer status);

    Integer approveaccount(@Param("employeeid")Integer employeeid, @Param("status") Integer status);

    List<Employee> getAllEmps(@Param("emp") Employee employee, @Param("page") Integer page, @Param("pagesize") Integer pageSize);

    long getTotal(Employee employee);

    List<Employee> getEmpsByDepId(Integer depId);

}
