package exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ExceptionEnum {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User not found in our database"),

    ;

    private final HttpStatus httpStatus;
    private final String message;
}
