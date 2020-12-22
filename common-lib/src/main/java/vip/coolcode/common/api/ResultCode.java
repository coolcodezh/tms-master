package vip.coolcode.common.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.servlet.http.HttpServletResponse;

@Getter
@AllArgsConstructor
public enum ResultCode {

    SUCCESS(HttpServletResponse.SC_OK, "操作成功"),
    FAILURE(HttpServletResponse.SC_BAD_REQUEST, "错误的请求"),
    UN_UNAUTHORIZED(HttpServletResponse.SC_UNAUTHORIZED, "请求无权限"),
    NOT_FOUND(HttpServletResponse.SC_NOT_FOUND, "找不到服务资源"),
    METHOD_NOT_SUPPORTED(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "不支持的请求方法"),
    MSG_NOT_READABLE(HttpServletResponse.SC_BAD_REQUEST, "不能读取消息"),
    MEDIA_TYPE_NOT_SUPPORTED(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, "不支持的消息类型"),
    INTERNAL_SERVER_ERROR(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "服务内部错误"),

    PARAM_MISS(HttpServletResponse.SC_BAD_REQUEST, "未传递参数"),
    PARAM_TYPE_ERROR(HttpServletResponse.SC_BAD_REQUEST, "参数类型错误"),
    PARAM_BIND_ERROR(HttpServletResponse.SC_BAD_REQUEST, "参数绑定错误"),
    PARAM_VALID_ERROR(HttpServletResponse.SC_BAD_REQUEST, "参数验证错误");


    final int code;
    final String msg;

}
