package main.java.com.learning.day4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Q5 {
    public static void main(String[] args) {
        ArrayList<Employee> ar=new ArrayList<Employee>();
        ar.add(new Employee("ankit",20.0,20000.0));
        ar.add(new Employee("sagar",21.0,25000.0));
        ar.add(new Employee("manna",18.0,15000.0));
        ar.add(new Employee("mohit",25.0,12000.0));
        ar.add(new Employee("ishika",24.0,30000.0));
        ar.add(new Employee("amisha",19.0,40000.0));
        Collections.sort(ar, new CompareBySalary());
        for(int i=0;i<ar.size();i++){
            System.out.println(ar.get(i));
        }
    }
}
class Employee {
    String Name;
    Double Age;
    Double Salary;
    Employee(String n, Double a, Double s){
        this.Name=n;
        this.Age=a;
        this.Salary=s;
    }
    public String toString(){
        return Name+" "+Age+" "+Salary;
    }
}
class CompareBySalary implements Comparator<Employee> {
    public int compare(Employee e1, Employee e2){
        if(e1.Salary>e2.Salary)
            return -1;
        else if(e1.Salary<e2.Salary)
            return 1;
        else
            return 0;
    }
}