package com.springbootrest.dao;

import com.springbootrest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
        /*Session session = entityManager.unwrap(Session.class);
        List<Employee> allEmployees = session.createQuery("from Employee", Employee.class).getResultList();*/
        Query query = entityManager.createQuery("from Employee");
        List<Employee> allEmployees = query.getResultList();
        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        /*Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);*/
        Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId());
    }

    @Override
    public Employee getEmployee(int id) {
       /* Session session = entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class, id);*/
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
      /*  Session session = entityManager.unwrap(Session.class);
        Query<Employee> query = session.createQuery("delete from Employee where id =: employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();*/
        Query query = entityManager.createQuery("delete from Employee where id =: employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
