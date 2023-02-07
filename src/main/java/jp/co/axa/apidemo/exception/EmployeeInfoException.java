package jp.co.axa.apidemo.exception;


import lombok.NonNull;
import org.springframework.boot.logging.LogLevel;
import org.springframework.http.HttpStatus;


public class EmployeeInfoException extends EmployeeException {

    /**
     * type of employee exception
     */
    public enum Type {
        BAD_ARGUMENTS(
                HttpStatus.BAD_REQUEST, EmployeeException.ERROR_CODE_BAD_ARGUMENTS, LogLevel.ERROR
        ),
        UNKNOWN(
                HttpStatus.INTERNAL_SERVER_ERROR, EmployeeException.ERROR_CODE_INTERNAL_ERROR, LogLevel.FATAL
        ),
        NOT_FOUND(
                HttpStatus.NOT_FOUND, EmployeeException.ERROR_CODE_NOT_FOUND, LogLevel.INFO
        );

        private HttpStatus status; // status that should be returned for this exception
        private Integer errorCode; // result code that should be returned for this exception
        private LogLevel logLevel; // log level

        Type(HttpStatus status, Integer errorCode, LogLevel logLevel) {
            this.errorCode = errorCode;
            this.status = status;
            this.logLevel = logLevel;
        }
    }

    private Type type;

    public EmployeeInfoException(Type type) {
        super(type);
        this.type = type;
    }

    public EmployeeInfoException(Type type, Exception e) {
        super(type, e);
        this.type = type;
    }

    @Override
    @NonNull
    public Type getType() {
        return type;
    }

    @Override
    @NonNull
    public HttpStatus getStatus() {
        return type.status;
    }

    @Override
    @NonNull
    public Integer getErrorCode() {
        return type.errorCode;
    }

    @NonNull
    @Override
    public LogLevel getLogLevel() {
        return type.logLevel;
    }
}