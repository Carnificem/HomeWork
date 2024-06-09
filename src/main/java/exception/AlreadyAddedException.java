package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class AlreadyAddedException extends Exception {
    public AlreadyAddedException(String massage) {
        super(massage);
    }
}
