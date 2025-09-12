package template.choi.java_spring_clean_arci.common.dto;

public record ResponseDto<T>(
        int code,
        String message,
        boolean isSuccess,
        T data) {

    public ResponseDto(ResponseCode responseCode) {
        this(responseCode.getCode(), responseCode.getMessage(), responseCode.isSuccess(), null);
    }
}

