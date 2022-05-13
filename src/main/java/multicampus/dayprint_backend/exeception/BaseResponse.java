package multicampus.dayprint_backend.exeception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.http.HttpHeaders;

import static multicampus.dayprint_backend.exeception.BaseResponseCode.OK;

@Getter
public class BaseResponse<T> {

    private final String code; // 상태 코드 메시지
    private final String message; // 에러 설명
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;

    // 요청 실패
    public BaseResponse(BaseResponseCode baseResponseCode) {
        this.code = baseResponseCode.getStatus().name();
        this.message = baseResponseCode.getMessage();
    }


    // 요청에 성공한 경우
    public BaseResponse(T result) {
        this.code = OK.getStatus().name();
        this.message = OK.getMessage();
        this.result = result;
    }

    public BaseResponse(String error, String message) {
        this.code = error;
        this.message = message;
    }
}
