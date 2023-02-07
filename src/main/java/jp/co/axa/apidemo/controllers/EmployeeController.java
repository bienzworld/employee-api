package jp.co.axa.apidemo.controllers;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.response.BaseResponse;
import jp.co.axa.apidemo.response.EmployeeResponse;
import jp.co.axa.apidemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * API that calls all list of employees
     * HTTP GET Request
     * @author Bien Carlo San Jose
     * @exception NotFound
     * @return Lists of employee info.
     */
    @GetMapping("/employees")
    public ResponseEntity<EmployeeResponse> getEmployees() throws Exception{
        EmployeeResponse response = employeeService.retrieveEmployees();
        String message = response.getStatusCode().toString();
        response.setMessage(message);
        return new ResponseEntity<>(response, response.getStatusCode());
    }

    /**
     * API that calls employee info using employee id
     * HTTP GET Request
     * @param employeeId
     * @author Bien Carlo San Jose
     * @exception Any Exception
     * @return Employee info based on employee id.
     */
    @GetMapping("/employees/{employeeId}")
    public  ResponseEntity<EmployeeResponse> getEmployee(@PathVariable(name="employeeId")Long employeeId) throws Exception {
        EmployeeResponse response = employeeService.getEmployee(employeeId);
        String message = response.getStatusCode().toString();
        response.setMessage(message);
        return new ResponseEntity<>(response, response.getStatusCode());
    }

    /**
     * API that inserts employee info
     * HTTP POST Request
     * @param employee
     * @author Bien Carlo San Jose
     * @exception Any Exception
     * @return Inserts employee info to the database
     */
    @PostMapping("/employees")
    public ResponseEntity<BaseResponse> saveEmployee(Employee employee){
        BaseResponse response = employeeService.saveEmployee(employee);
        System.out.println("Employee Saved Successfully");

        String message = response.getStatusCode().toString();
        response.setMessage(message);
        return new ResponseEntity<>(response, response.getStatusCode());
    }

    /**
     * API that deletes employee info record in the database
     * HTTP DELETE Request
     * @param employeeId
     * @author Bien Carlo San Jose
     * @exception Any Exception
     * @return Deletes employee info on the database
     */
    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<BaseResponse> deleteEmployee(@PathVariable(name="employeeId")Long employeeId){
        BaseResponse response = employeeService.deleteEmployee(employeeId);
        System.out.println("Employee Deleted Successfully");

        String message = response.getStatusCode().toString();
        response.setMessage(message);
        return new ResponseEntity<>(response, response.getStatusCode());
    }

    /**
     * API that modifies employee info
     * HTTP Put Request
     * @param employee, employeeId
     * @author Bien Carlo San Jose
     * @exception Any Exception
     * @return Updates employee info on the database
     */
    @PutMapping("/employees/{employeeId}")
    public ResponseEntity<BaseResponse> updateEmployee(@RequestBody Employee employee,
                               @PathVariable(name="employeeId")Long employeeId){
        BaseResponse response = employeeService.updateEmployee(employeeId, employee);
        String message = response.getStatusCode().toString();
        response.setMessage(message);
        return new ResponseEntity<>(response, response.getStatusCode());
    }

}
