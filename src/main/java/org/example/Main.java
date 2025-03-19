package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1,"John", "Doe"));
        employees.add(new Employee(2,"Marie", "Clare"));
        employees.add(new Employee(3,"Hasan", "Hüseyin"));
        employees.add(new Employee(2, "Ayşe", "Yılmaz"));

        List<Employee> duplicates = findDuplicates(employees);
        Map<Integer,Employee> uniques = findUniques(employees);
        List<Employee> removed = removeDuplicates(employees);

       System.out.println("Dublicates: " + duplicates);
       System.out.println("Uniques: " + uniques);
        System.out.println("Removed: " + removed);


        System.out.println(WordCounter.calculatedWord());
    }

    public static List<Employee> findDuplicates(List<Employee> employees){
        Map<Integer, Employee> employeeMap = new HashMap<>();
        List<Employee> dublicates = new ArrayList<>();

        for(Employee employee: employees){
            if (employee == null) {
                continue;
            }
            if(employeeMap.containsKey(employee.getId())){
                dublicates.add(employee);
            }else {
                employeeMap.put(employee.getId(), employee);
            }
        }
        return dublicates;
    }

    public static Map<Integer,Employee> findUniques(List<Employee> employees){
        Map<Integer, Employee> employeeMap = new HashMap<>();

        for(Employee employee: employees){
            if (employee == null) {
                continue;
            }
            if(employeeMap.containsKey(employee.getId())){
            }else {
                employeeMap.put(employee.getId(), employee);
            }
        }
        return employeeMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees){
        Map<Integer,Integer> idCount = new HashMap<>();
        List<Employee> removedDublicates = new LinkedList<>();

        for(Employee employee: employees){
            if (employee == null) {
                continue;
            }
            int id = employee.getId();

            if(idCount.containsKey(id)){
                idCount.put(id, idCount.get(id) + 1);
            }else{
                idCount.put(id,1);
            }
        }

        for (Employee employee: employees){
            if (employee == null) {
                continue;
            }
            if(idCount.get(employee.getId()) == 1){
                removedDublicates.add(employee);
            }
        }
        return removedDublicates;
    }

}