package org.foryou.admin.vo;

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

    public static enum CodeType {
        SUCCESS(0),
        FAIL(1);

        private int code;

        CodeType(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }
}
