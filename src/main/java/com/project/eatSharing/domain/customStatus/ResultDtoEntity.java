package com.project.eatSharing.domain.customStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@Builder
public class ResultDtoEntity<T> {

    private final int httpStatusCode;
    private final String message;
    private final T resultData;

    public ResultDtoEntity(HttpStatus httpStatus, String message) {
        this.httpStatusCode = httpStatus.value();
        this.message = message;
        this.resultData = null;
    }

    public static<T> ResultDtoEntity<T> resCodeMessage(T t){
        return resCodeMessage(HttpStatus.OK, "Success", t);

    }

    public static<T> ResultDtoEntity<T> resCodeMessage(HttpStatus status, String msg){
        return resCodeMessage(status, msg,null);

    }

    public static<T> ResultDtoEntity<T> resCodeMessage(HttpStatus status, String msg, T t){
        return ResultDtoEntity.<T>builder()
                .httpStatusCode(status.value())
                .message(msg)
                .resultData(t)
                .build();
    }
}
