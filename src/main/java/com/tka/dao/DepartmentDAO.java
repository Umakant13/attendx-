package com.tka.dao;

import java.util.List;
import com.tka.entity.Department;

public interface DepartmentDAO {
    List<Department> getAllDepartments();
    Department getDepartmentById(Long id);
    void saveDepartment(Department department);
    void deleteDepartment(Long id);

}
