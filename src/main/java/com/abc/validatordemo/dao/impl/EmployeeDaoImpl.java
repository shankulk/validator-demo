package com.abc.validatordemo.dao.impl;

import com.abc.validatordemo.dao.EmployeeDao;
import com.abc.validatordemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    EntityManager entityManager;


    @Override
    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public Employee merge(Employee employee) {
        return (Employee) entityManager.merge(employee);
    }
}
