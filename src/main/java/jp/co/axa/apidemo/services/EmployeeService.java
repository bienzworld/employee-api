package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.exception.EmployeeInfoException;
import jp.co.axa.apidemo.response.BaseResponse;
import jp.co.axa.apidemo.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    public EmployeeResponse retrieveEmployees() throws EmployeeInfoException;

    public EmployeeResponse getEmployee(Long employeeId) throws EmployeeInfoException;

    public BaseResponse saveEmployee(Employee employee);

    public BaseResponse deleteEmployee(Long employeeId);

    public BaseResponse updateEmployee(long employeeId, Employee employee);
}