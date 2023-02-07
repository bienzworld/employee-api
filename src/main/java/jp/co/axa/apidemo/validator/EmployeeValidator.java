package jp.co.axa.apidemo.validator;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.exception.EmployeeInfoException;
import jp.co.axa.apidemo.response.EmployeeResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeValidator {

    /**
     * validate employee list
     * @author    Bien Carlo San Jose
     */
    public void validateEmployeeList(List<Employee> employeeList) throws EmployeeInfoException {
        if(employeeList.isEmpty()) {
            throw new EmployeeInfoException(EmployeeInfoException.Type.NOT_FOUND);
        }
    }

    /**
     * validate specific employee
     * @author    Bien Carlo San Jose
     */
    public void validateEmployeeIdResult(Optional<Employee> employeeOptional) throws EmployeeInfoException {
        if(ObjectUtils.isEmpty(employeeOptional)) {
            throw new EmployeeInfoException(EmployeeInfoException.Type.BAD_ARGUMENTS);
        }
    }

    /**
     * validate specific employee
     * @author    Bien Carlo San Jose
     */
    public void validateEmptyEmployee(Employee employee) throws EmployeeInfoException{
        if(ObjectUtils.isEmpty(employee) || employee.getName().isEmpty()) {
            throw new EmployeeInfoException(EmployeeInfoException.Type.UNKNOWN);
        }
    }
}
