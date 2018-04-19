package org.foryou.admin.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseVo<T> {
    private int code;
    private String message;
    private T data;

    public ResponseVo(CodeType codeType, String message, T data) {
        this.code = codeType.getCode();
        this.message = message;
        this.data = data;
    }

    public ResponseVo(CodeType codeType, T data) {
        this.code = codeType.getCode();
        this.setMessage("success");
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(CodeType codeType) {
        this.code = codeType.getCode();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public enum CodeType {
        SUCCESS(0),
        SYSTEM_ERROR(1),
        FAIL(2);

        private int code;

        CodeType(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }
}
