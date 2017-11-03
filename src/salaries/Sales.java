/* 
 * File: Sales.java
 * Author: Michelle John
 * Date 02 Nov 2017
 * Purpose: Project 1: Store employee monthly salary information and return annual salary
 */
package salaries;

/**
 * Class that holds information for Sales employees and extends {@link Employee}. 
 */
public class Sales extends Employee {
    
  private static final double COMMISSION_RATE = 0.02;
    
  private double annualSales;
  
  /**
   * Constructor.
   * 
   * @param name the employee's name
   * @param salary the monthly salary of the employee
   * @param annualSales the annual sales of the employee
   */
  public Sales(String name, double salary, double annualSales) {
    super(name, salary);
    this.annualSales = annualSales;
  }

  /**
   * @return the annual sales of the employee
   */
  public double getAnnualSales() {
    return annualSales;
  }

  /**
   * @param annualSales the annual sales of the employee
   */
  public void setAnnualSales(double annualSales) {
    this.annualSales = annualSales;
  }
    
  /**
   * @return the amount of the commission earned by the employee
   */
  public double getCommission() {
    return annualSales * COMMISSION_RATE;
  }
    
  @Override
  public double getAnnualSalary() {
    double commission = getCommission() > 20_000 ? 20_000 : getCommission();
    return getMonthlySalary() * MONTHS_IN_YEAR + commission;
  }
    
  @Override
  public String toString() {
    return super.toString() + "\nAnnual Sales: " + annualSales;
  }
}
