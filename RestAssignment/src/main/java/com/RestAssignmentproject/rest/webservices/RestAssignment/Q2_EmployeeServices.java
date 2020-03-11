package com.RestAssignmentproject.rest.webservices.RestAssignment;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Repository
public class Q2_EmployeeServices {
    private static List<Q2_Employee> employees = new ArrayList<>();
    private static int count = 3;

    static {
        employees.add(new Q2_Employee(1, "apoorva", 20));
        employees.add(new Q2_Employee(2, "kittu", 25));
        employees.add(new Q2_Employee(3, "yash", 22));
    }
/////////////////This method is used to show all the Employee Details///////////////////
    public List<Q2_Employee> FindAll() {
        return employees;
    }

    public Q2_Employee save(Q2_Employee employee) {
        if (employee.getId() == null) {
            employee.setId(++count);
        }
        employees.add(employee);
        return employee;
    }
/////////////////This method is used to show a particular Employee Details whose id we have passed///////////
    /*
    For Example
    localhost:8080/Employee/1
    it will give the deails of first employee
     */
    public Q2_Employee findone(Integer id) {
        for (Q2_Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
    /////////////////This method is used to delete a particular Employee Details whose id we have passed///////////
    /*
    For Example
    localhost:8080/Employee/1
    it will give the delete the details of first employee from the list
     */

    public Q2_Employee deleteById(int id) {
        Iterator<Q2_Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Q2_Employee employee = iterator.next();
            if (employee.getId() == id) {
                iterator.remove();
                return employee;
            }
        }
        return null;
    }
    /////////////////This method is used to update a particular Employee Details whose id we have passed///////////
    /*
    For Example
    localhost:8080/Employee/1
    it will give the update the details of first employee from the list
     */
    public void putEmp(Integer id,Q2_Employee employee){
        Iterator<Q2_Employee> iterator=employees.iterator();
        while(iterator.hasNext()){
            if(iterator.next().getId()==id){
                iterator.next().setName(employee.getName());
                iterator.next().setAge(employee.getAge());
            }
        }
    }
}
