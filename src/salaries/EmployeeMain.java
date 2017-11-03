/* 
 * File: EmployeeMain.java
 * Author: Michelle John
 * Date 02 Nov 2017
 * Purpose: Project 1: Store employee monthly salary information and return annual salary
 */
package salaries;

import static salaries.EmployeeUtils.createEmployee;
import static salaries.EmployeeUtils.stringToPrint;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The main class for this application.
 */
public class EmployeeMain {

  public static void main(String[] args) {
    String fileLine;
    List<String> employeeList = new ArrayList<String>();
    List<Employee> employeeList2014 = new ArrayList<Employee>();
    List<Employee> employeeList2015 = new ArrayList<Employee>();

    final String tableTitle = String.format("%-5s%-22s%-8s%12s%10s%10s%18s\n"
        + "-------------------------------------------------------------------------------------", 
        "YEAR", "NAME", "TYPE", "MONTHLY", "ANNUAL", "SALES", "STOCK PRICE");
    
    // Read info from the file and create the employee lists
    try (BufferedReader inputStream = new BufferedReader(new FileReader(new File(EmployeeMain.class
        .getResource("EmployeeList.txt").getFile())))) {
      while ((fileLine = inputStream.readLine()) != null) {
        employeeList.add(fileLine);
      }
      employeeList.forEach(entry -> {
        String[] employeeEntry = entry.split(" ");
        if ("2014".equals(employeeEntry[0])) {
          employeeList2014.add(createEmployee(employeeEntry));
        }
        if ("2015".equals(employeeEntry[0])) {
          employeeList2015.add(createEmployee(employeeEntry));
        }
      });
    } catch (IOException exception) {
      System.err.println("Exception caught");
    }
    
    // Print the table
    System.out.println(tableTitle);
    employeeList2014.forEach(employee -> {
      System.out.printf("2014 " + stringToPrint(employee));
    });
    System.out.printf("-----\nAverage Annual Salary: %10.2f\n", 
        employeeList2014.stream().mapToDouble(Employee::getAnnualSalary).sum()/employeeList2014.size());
    
    System.out.println("\n\n" + tableTitle);
    employeeList2015.forEach(employee -> {
      System.out.printf("2015 " + stringToPrint(employee));
    });
    System.out.printf("-----\nAverage Annual Salary: %10.2f\n", 
        employeeList2015.stream().mapToDouble(Employee::getAnnualSalary).sum()/employeeList2015.size());
  }
}
