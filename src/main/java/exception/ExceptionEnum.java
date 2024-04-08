package exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public class ExceptionEnum {

    private final HttpStatus httpStatus;
    private final String message;
}
