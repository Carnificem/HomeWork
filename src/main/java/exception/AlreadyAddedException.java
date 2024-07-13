package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AlreadyAddedException extends RuntimeException {
    public AlreadyAddedException(){

    }

    public AlreadyAddedException(String massage) {

    }

    public AlreadyAddedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlreadyAddedException(Throwable cause) {
        super(cause);
    }

    public AlreadyAddedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}



