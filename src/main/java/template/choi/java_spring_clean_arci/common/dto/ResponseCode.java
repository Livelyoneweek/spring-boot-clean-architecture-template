package template.choi.java_spring_clean_arci.common.dto;

import lombok.Getter;

@Getter
public enum ResponseCode {
    SUCCESS(true, 200, "Request successful."),
    BAD_REQUEST(false, 400, "요청 정보 확인바랍니다."),
    FORBIDDEN(false, 403, "금지되었습니다."),
    UNAUTHORIZED(false, 403, "인증되지 않았습니다..");

    private final boolean isSuccess;
    private final int code;
    private final String message;

    ResponseCode(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}
