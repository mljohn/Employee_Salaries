/* 
 * File: EmployeeUtils.java
 * Author: Michelle John
 * Date 02 Nov 2017
 * Purpose: Project 1: Store employee monthly salary information and return annual salary
 */
package salaries;

import static java.lang.Double.parseDouble;

/**
 * Utility methods for this application.
 */
public final class EmployeeUtils {

  /**
   * Private constructor to prevent instantiation.
   */
  private EmployeeUtils() {}
  
  /**
   * Creates an {@link Employee}, {@link Sales}, or {@link Executive} object, based on employee type.
   * 
   * @param employeeInfo the {@code String[]} that holds employee information
   * @return a new {@link Employee}, {@link Sales}, or {@link Executive} object as determined by employee type
   */
  public static Employee createEmployee(String[] employeeInfo) {
    switch (employeeInfo[1]) {
      case "Employee": return new Employee(employeeInfo[2], parseDouble(employeeInfo[3]));
      case "Sales": 
        return new Sales(employeeInfo[2], parseDouble(employeeInfo[3]), parseDouble(employeeInfo[4]));
      case "Executive": 
        return new Executive(employeeInfo[2], parseDouble(employeeInfo[3]), parseDouble(employeeInfo[4]));
    }
    return null;
  }

  /**
   * Creates the string to print to the summary table.
   * 
   * @param employee the {@link Employee} object to get the necessary information from
   * @return the string to print to the table
   */
  public static String stringToPrint(Employee employee) {
    String employeeType = employee.getClass().getName().substring(9); // The index after the "." in the class name
    String initialString = String.format("%-22s%-10s%10.2f%12.2f", 
        employee.getName(), employeeType, employee.getMonthlySalary(), employee.getAnnualSalary());
    switch (employeeType) {
      case "Employee": return initialString + "\n";
      case "Sales": return initialString + String.format("%12.2f\n", ((Sales) employee).getAnnualSales());
      case "Executive": return initialString + String.format("%20.2f\n", ((Executive) employee).getStockPrice());
      default: return null;
    }
  }
}
