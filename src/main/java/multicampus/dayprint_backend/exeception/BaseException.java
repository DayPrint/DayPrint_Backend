package multicampus.dayprint_backend.exeception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BaseException extends RuntimeException {
    private final BaseResponseCode baseResponseCode;
}
