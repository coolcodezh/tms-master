package vip.coolcode.common.error;

import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import vip.coolcode.common.api.BaseResponse;
import vip.coolcode.common.api.ResultCode;

@RestControllerAdvice
public class GlobalExceptionTranslator {

    @ExceptionHandler(ServiceException.class)
    public BaseResponse handleError(ServiceException e) {
        BaseResponse baseResponse =
                BaseResponse.builder()
                        .code(ResultCode.PARAM_MISS)
                        .message(e.getMessage())
                        .build();
        return baseResponse;
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public BaseResponse handleError(MissingServletRequestParameterException e) {
        String message = "参数丢失: " + e.getParameterName();
        BaseResponse baseResponse =
                BaseResponse.builder()
                        .code(ResultCode.PARAM_MISS)
                        .message(message)
                        .build();
        return baseResponse;
    }

    //MethodArgumentNotValidException
    //MethodArgumentTypeMismatchException

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public BaseResponse handleError(HttpMediaTypeNotSupportedException e) {
        BaseResponse baseResponse =
                BaseResponse.builder()
                        .code(ResultCode.MEDIA_TYPE_NOT_SUPPORTED)
                        .message("媒体类型不支持")
                        .build();
        return baseResponse;
    }

}
