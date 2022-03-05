package com.mman.meeting.mapper;

import com.mman.meeting.model.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 莫曼
 * @version 1.0
 */
public interface DepartmentMapper {
    Department getDepById(Integer id);

    List<Department> getAllDeps();

    Integer adddepartment(String departmentname);

    Department getDepByName(String departmentname);

    Integer deletedep(Integer departmentid);

    Integer updatedep(@Param("id") Integer id, @Param("name") String name);
}
