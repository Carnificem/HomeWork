package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class EmployeeStorageIsFullException extends Exception {
    public EmployeeStorageIsFullException(String massage) {
        super(massage);
    }
}
