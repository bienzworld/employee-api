package jp.co.axa.apidemo.exception;

import lombok.NonNull;
import org.springframework.boot.logging.LogLevel;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;

public abstract class EmployeeException extends Exception {

    //common error for employee api
    public static final int ERROR_CODE_BAD_ARGUMENTS = 1;
    public static final int ERROR_CODE_INTERNAL_ERROR = 2;
    public static final int ERROR_CODE_NOT_FOUND = 3;

    public EmployeeException(Enum type) { super("Type: " + type.name()); }

    public EmployeeException(Enum type, Exception e) { super("Type: " + type.name(),e); }

    public EmployeeException(Enum type, String message) { super("Type: " + type.name() + ", Error message:" + message);}

    public abstract Enum getType();

    @NonNull
    public abstract HttpStatus getStatus();

    public abstract Integer getErrorCode();

    @NonNull
    public abstract LogLevel getLogLevel();

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof EmployeeException) && ((EmployeeException) obj).getType() == getType() &&
                ObjectUtils.nullSafeEquals(((EmployeeException)obj).getMessage(), getMessage());
    }


}

