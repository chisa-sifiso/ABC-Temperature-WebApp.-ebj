/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.bl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import za.ac.tut.models.Employee;

/**
 *
 * @author Sifiso
 */
@Stateless
public class EmployeeFacade extends AbstractFacade<Employee> implements EmployeeFacadeLocal {

    @PersistenceContext(unitName = "ABCTempEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeeFacade() {
        super(Employee.class);
    }

    @Override
    public Long determineNumberOfHighTemperatureEmployees() {
      Query query = em.createQuery("SELECT COUNT(e) FROM Employee e WHERE e.tempReading>38");
      Long cnt = (Long)query.getSingleResult();
      return cnt;
    }

    @Override
    public Long determineNumberOfLowTemperatureEmployees() {
      Query query = em.createQuery("SELECT COUNT(e) FROM Employee e WHERE e.tempReading<=38");
      Long cnt = (Long)query.getSingleResult();
      return cnt;
    }
    
}
