/* 
 * File: SalesTest.java
 * Author: Michelle John
 * Date 02 Nov 2017
 * Purpose: Project 1: Store employee monthly salary information and return annual salary
 */
package test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import salaries.Sales;

public class SalesTest {
  
  private Sales testSales;
  
  @Before
  public void setup() {
    testSales = new Sales("Doe,John", 2500, 250_000);
  }
  
  @Test
  public void testConstructor() {
    assertThat(testSales, notNullValue());
  }
  
  @Test
  public void testGettersSetters() {
    // test
    testSales.setAnnualSales(350_000);
    
    // verify
    assertThat(testSales.getAnnualSales(), equalTo(350_000.0));
    assertThat(testSales.getCommission(), equalTo(7000.0));
  }

  @Test
  public void testGetAnnualSalary_commissionGreaterThanMax() {
    // setup
    Sales salesTest = new Sales("Johh,Michelle", 2500, 2_500_000);
    
    // verify
    assertThat(salesTest.getAnnualSalary(), equalTo(50_000.0));
  }
  
  @Test
  public void testGetAnnualSalary_commissionLessThanMax() {
    // setup
    Sales salesTest = new Sales("John,Michelle", 2500, 100_000);
    
    // verify
    assertThat(salesTest.getAnnualSalary(), equalTo(32_000.0));
  }
  
  @Test
  public void testToString() {
    // verify
    assertThat(testSales.toString(), equalTo("Employee name: Doe,John\nMonthly Salary: 2500.0\nAnnual Sales: "
        + "250000.0"));
  }
}
