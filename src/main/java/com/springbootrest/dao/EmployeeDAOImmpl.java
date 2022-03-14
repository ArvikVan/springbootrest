package com.springbootrest.dao;

import com.springbootrest.entity.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author ArvikV
 * @version 1.0
 * @since 25.02.2022
 */
@Repository
public class EmployeeDAOImmpl implements EmployeeDAO {
    /**
     * Вместо sessionFactory используем EntityManager
     * используя жпа сессия не нужна, эту роль выполняет ентитиманагер
     * создавать бин для этого не надо, все делает под капотом
     */
    @Autowired
    private EntityManager entityManager;

    /**
     * sessionFactory.getCurrentSession(); меняем на entityManager.unwrap(Session.class);
     * но можно и на криэйтквери
     * @return
     */
    @Override
    public List<Employee> getAllEmployees() {
        Session session = entityManager.unwrap(Session.class);
        List<Employee> allEmployees = session.createQuery("from Employee", Employee.class).getResultList();
        return allEmployees;
    }

/*    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("delete from Employee where id =: employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();*//*для делит вызываем*//*
    }*/
}
