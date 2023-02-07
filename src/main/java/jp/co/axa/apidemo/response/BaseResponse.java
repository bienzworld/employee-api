package jp.co.axa.apidemo.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.axa.apidemo.exception.EmployeeException;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;

public class BaseResponse {

    @JsonIgnore
    protected HttpStatus statusCode;

    @JsonProperty("errorCode")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected Integer errorCode;

    @JsonProperty("message")
    protected String message;

    public BaseResponse() { this.statusCode = HttpStatus.OK; }

    public void setStatusCode(HttpStatus statusCode) { this.statusCode = statusCode; }

    public void setMessage(@NonNull String message) { this.message = message; }

    @NonNull
    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public <T extends EmployeeException> BaseResponse(@NonNull T e) {
        this.statusCode = e.getStatus();
        this.errorCode = e.getErrorCode();
    }
}
