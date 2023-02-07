package jp.co.axa.apidemo.service;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.response.BaseResponse;
import jp.co.axa.apidemo.response.EmployeeResponse;
import jp.co.axa.apidemo.services.EmployeeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    EmployeeServiceImpl employeeService;

    @Before
    public void initMocks() {
        Employee employee1 = new Employee(1L, "dummy1", 555, "dept1");
        Employee employee2 = new Employee(2L, "dummy2", 399, "dept2");
        employeeService.saveEmployee(employee1);
        employeeService.saveEmployee(employee2);
    }

    @Test
    public void returnAllEmployeeInfo() {
        EmployeeResponse response = employeeService.retrieveEmployees();
        assertTrue("return 200", response.getStatusCode() == HttpStatus.OK);
    }

    @Test
    public void returnEmployeeInfoById() {
        EmployeeResponse response = employeeService.getEmployee(2L);
        assertTrue("return 200", response.getStatusCode() == HttpStatus.OK);
    }

    @Test
    public void returnSaveEmployeeInfo() {
        Employee employee3 = new Employee(3L, "dummy3", 2423, "dept3");
        BaseResponse response = employeeService.saveEmployee(employee3);
        assertTrue("return 200", response.getStatusCode() == HttpStatus.OK);
    }

    @Test
    public void returnDeleteEmployeeInfo() {
        BaseResponse response = employeeService.deleteEmployee(2L);
        assertTrue("return 200", response.getStatusCode() == HttpStatus.OK);
    }

    @Test
    public void returnUpdateEmployeeInfo() {
        Employee employee4 = new Employee(4L, "dummy4", 223, "dept4");
        BaseResponse response = employeeService.updateEmployee(1L, employee4);
        assertTrue("return 200", response.getStatusCode() == HttpStatus.OK);
    }
}
