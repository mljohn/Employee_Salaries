/* 
 * File: ExecutiveTest.java
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

import salaries.Executive;

/**
 * Test class for {@link Executive}.
 */
public class ExecutiveTest {
  
  private Executive testExecutive;
  
  @Before
  public void setup() {
    testExecutive = new Executive("Doe,John", 5000, 55);
  }
  
  @Test
  public void testConstructor() {
    // verify
    assertThat(testExecutive, notNullValue());
  }
  
  @Test
  public void testGettersSetters() {
    //test
    testExecutive.setStockPrice(60.0); 
    
    // verify
    assertThat(testExecutive.getStockPrice(), equalTo(60.0));
  }
  
  @Test
  public void testGetAnnualSalary_stockPriceMoreThanFifty() {
    // verify
    assertThat(testExecutive.getAnnualSalary(), equalTo(90_000.0));
  }
  
  @Test
  public void testGetAnnualSalary_stockPriceLessThanFifty() {
    // setup
    Executive executiveTest = new Executive("Richie,Rich", 6000, 35);
    
    // verify
    assertThat(executiveTest.getAnnualSalary(), equalTo(72_000.0));
  }
  
  @Test
  public void testToString() {
    // verify
    assertThat(testExecutive.toString(), equalTo("Employee name: Doe,John\nMonthly Salary: 5000.0\nStock Price: "
        + "55.0"));
  }
}
