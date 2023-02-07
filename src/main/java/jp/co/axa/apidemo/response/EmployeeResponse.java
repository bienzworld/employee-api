package jp.co.axa.apidemo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.exception.EmployeeInfoException;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public class EmployeeResponse extends  BaseResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("employee")
    private Optional<Employee> employee;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("employees")
    private List<Employee> employees;

    private long id;

    public EmployeeResponse() { super(); }

    public EmployeeResponse(Optional<Employee> employee) {
        super();
        this.employee = employee;
    }

    public EmployeeResponse(List<Employee> employees) {
        super();
        this.employees = employees;
    }

    public EmployeeResponse(@NonNull EmployeeInfoException e) {
        super(e);
    }

}
