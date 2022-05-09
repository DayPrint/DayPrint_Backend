package multicampus.dayprint_backend.exeception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(BaseException.class)
    protected ResponseEntity<BaseResponse> handleBaseException(final BaseException e) {
        return ResponseEntity.status(e.getBaseResponseCode().getStatus().value())
                .body(new BaseResponse(e.getBaseResponseCode()));
    }
}