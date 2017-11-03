/* 
 * File: Executive.java
 * Author: Michelle John
 * Date 02 Nov 2017
 * Purpose: Project 1: Store employee monthly salary information and return annual salary
 */
package salaries;

/**
 * Class that hold information for Executives and extends {@link Employee}. 
 */
public class Executive extends Employee {
    
  private double stockPrice;
    
  /**
   * Constructor.
   * 
   * @param name the executive's name
   * @param monthlySalary the monthly salary of the executive
   * @param stockPrice the price of one share of the company's stock
   */
  public Executive(String name, double monthlySalary, double stockPrice) {
    super(name, monthlySalary);
    this.stockPrice = stockPrice;
  }

  /**
   * @return the price of one share of the company's stock
   */
  public double getStockPrice() {
    return stockPrice;
  }

  /**
   * @param stockPrice the price of one share of the company's stock
   */
  public void setStockPrice(double stockPrice) {
    this.stockPrice = stockPrice;
  }
    
  @Override
  public double getAnnualSalary() {
    double bonus = stockPrice > 50 ? 30_000 : 0;
    return getMonthlySalary() * MONTHS_IN_YEAR + bonus;
  }
    
  @Override
  public String toString() {
    return super.toString() + "\nStock Price: " + stockPrice;
  }
}
