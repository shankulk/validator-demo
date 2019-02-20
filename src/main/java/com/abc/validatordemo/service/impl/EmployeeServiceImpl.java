package com.abc.validatordemo.service.impl;

import com.abc.validatordemo.dao.EmployeeDao;
import com.abc.validatordemo.entity.Employee;
import com.abc.validatordemo.service.EmployeeService;
import com.abc.validatordemo.validator.ValidationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    ValidationManager validationManager;

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Employee createEmployeeRecord(Employee employee) {
        validationManager.validate(employee);
        return employeeDao.merge(employee);
    }
}
