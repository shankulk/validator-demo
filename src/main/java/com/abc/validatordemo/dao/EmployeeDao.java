package com.abc.validatordemo.dao;

import com.abc.validatordemo.entity.Employee;

public interface EmployeeDao {
    void save(Employee employee);

    Employee merge(Employee employee);
}
