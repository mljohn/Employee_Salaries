/* 
 * File: Employee.java
 * Author: Michelle John
 * Date 02 Nov 2017
 * Purpose: Project 1: Store employee monthly salary information and return annual salary
 */
package salaries;

/**
 * Class to hold Employee information.
 */
public class Employee {

  public static final int MONTHS_IN_YEAR = 12;

  private String name;
  private double monthlySalary;

  /**
   * Constructor.
   * 
   * @param name the employee's name
   * @param salary the employee's monthly salary
   */
  public Employee(String name, double salary) {
    this.name = name;
    this.monthlySalary = salary;
  }
  
  /**
   * @return the employee's name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the employee's name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the employee's monthly salary
   */
  public double getMonthlySalary() {
    return monthlySalary;
  }

  /**
   * @param salary the employee's monthly salary to set
   */
  public void setMonthlySalary(double salary) {
    this.monthlySalary = salary;
  }

  /**
   * @return the annual salary of the employee
   */
  public double getAnnualSalary() {
    return monthlySalary * MONTHS_IN_YEAR;
  }

  /**
   * Returns the employee's information
   */
  @Override
  public String toString() {
    return "Employee name: " + name + "\nMonthly Salary: " + monthlySalary;
  }
}
