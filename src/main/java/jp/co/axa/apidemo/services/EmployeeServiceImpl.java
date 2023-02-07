package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.exception.EmployeeInfoException;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import jp.co.axa.apidemo.response.BaseResponse;
import jp.co.axa.apidemo.response.EmployeeResponse;
import jp.co.axa.apidemo.validator.EmployeeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeValidator employeeValidator;

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Retrieves all employee info from database
     * @author    Bien Carlo San Jose
     */
    public EmployeeResponse retrieveEmployees() {
        EmployeeResponse response = new EmployeeResponse();
        try {
            // Get all employee records on the database
            List<Employee> employees = employeeRepository.findAll();
            // Validate the records should not be empty
            employeeValidator.validateEmployeeList(employees);
            response = new EmployeeResponse(employees);
        } catch (Exception e) {
            // return exception if no records found
            EmployeeInfoException exception = getEmployeeInfoException(e);
            response = new EmployeeResponse(exception);
        }
        return response;
    }

    /**
     * get employee info using employee id
     * @author    Bien Carlo San Jose
     */
    public EmployeeResponse getEmployee(Long id) {
        EmployeeResponse response = new EmployeeResponse();
        try {
            // Get employee info using employee id
            Optional<Employee> employee = employeeRepository.findById(id);
            // Validate employee info result
            employeeValidator.validateEmployeeIdResult(employee);
            response = new EmployeeResponse(employee);
        } catch (Exception e) {
            // return exception if no records found
            EmployeeInfoException exception = getEmployeeInfoException(e);
            response = new EmployeeResponse(exception);
        }
        return response;
    }

    /**
     * Saves employee info on the database
     * @author    Bien Carlo San Jose
     */
    @CachePut(value = "employees", key = "#employee.id")
    public BaseResponse saveEmployee(Employee employee) {
       BaseResponse response = new BaseResponse();
       try {
           // validate employee parameter
           employeeValidator.validateEmptyEmployee(employee);
           // save records on database
           employeeRepository.save(employee);
           response = new BaseResponse();
       } catch (Exception e) {
           // return exception when failed to save
           EmployeeInfoException exception = getEmployeeInfoException(e);
           response = new EmployeeResponse(exception);
       }
       return response;
    }

    /**
     * Delete employee info record on database
     * @author    Bien Carlo San Jose
     */
    @CacheEvict(value = "employees", key = "#id")
    public BaseResponse deleteEmployee(Long id){
        BaseResponse response = new BaseResponse();
        try {
            // delete employee info record on database
            employeeRepository.deleteById(id);
            response = new BaseResponse();
        } catch (Exception e) {
            // return exception when failed to delete
            EmployeeInfoException exception = getEmployeeInfoException(e);
            response = new EmployeeResponse(exception);
        }
        return response;
    }

    /**
     * Update employee info on database
     * @author    Bien Carlo San Jose
     */
    public BaseResponse updateEmployee(long employeeId, Employee employee) {
        BaseResponse response = new BaseResponse();
        try {
            // validate employee info not empty
            employeeValidator.validateEmptyEmployee(employee);
            Optional<Employee> checkId = employeeRepository.findById(employeeId);
            // delete employee info on database
            employeeRepository.deleteById(employeeId);
            // save updated record on database
            employeeRepository.save(employee);
            response = new BaseResponse();
        } catch (Exception e) {
            // return error when failed to update
            EmployeeInfoException exception = getEmployeeInfoException(e);
            response = new EmployeeResponse(exception);
        }
        return response;
    }

    /**
     * Employee info exception
     * @author    Bien Carlo San Jose
     */
    private EmployeeInfoException getEmployeeInfoException(@NonNull Exception e) {
        if (e instanceof EmployeeInfoException) {
            return (EmployeeInfoException) e;
        } else if (e instanceof IllegalArgumentException) {
            return new EmployeeInfoException(EmployeeInfoException.Type.BAD_ARGUMENTS, e);
        } else {
            return new EmployeeInfoException(EmployeeInfoException.Type.UNKNOWN);
        }
    }
}