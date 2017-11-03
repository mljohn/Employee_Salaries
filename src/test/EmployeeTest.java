/* 
 * File: EmployeeTest.java
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

import salaries.Employee;

/**
 * Tests for {@link Employee}.
 */
public class EmployeeTest {

  private Employee testEmployee;

  @Before
  public void setup() {
    testEmployee = new Employee("Doe,John", 2000);
  }

  @Test
  public void testConstructor() {
    // verify
    assertThat(testEmployee, notNullValue());
  }

  @Test
  public void testGettersSetters() {
    // test
    testEmployee.setName("John,Michelle");
    testEmployee.setMonthlySalary(3000.0);
    
    // verify
    assertThat(testEmployee.getName(), equalTo("John,Michelle"));
    assertThat(testEmployee.getMonthlySalary(), equalTo(3000.0));
  }
  
  @Test 
  public void testGetAnnualSalary() {
    // verify
    assertThat(testEmployee.getAnnualSalary(), equalTo(24_000.0));
    
  }
  
  @Test
  public void testToString() {
    // verify
    assertThat(testEmployee.toString(), equalTo("Employee name: Doe,John\nMonthly Salary: 2000.0"));
  }
}
