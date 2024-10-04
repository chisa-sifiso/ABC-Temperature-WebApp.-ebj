/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.bl;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.models.Employee;

/**
 *
 * @author Sifiso
 */
@Local
public interface EmployeeFacadeLocal {

    void create(Employee employee);

    Long determineNumberOfHighTemperatureEmployees();
    
    Long determineNumberOfLowTemperatureEmployees();
    
}
