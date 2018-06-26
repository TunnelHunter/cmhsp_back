package cn.psychology.Util;

public enum RespCode {
    SUCCESS(0, "请求成功"),
    WARN(-1, "网络异常，请稍后重试");

    private int error_code;
    private String msg;

    RespCode(int error_code, String msg) {
        this.msg = msg;
    }

    public int getError_code() {
        return error_code;
    }
    public String getMsg() {
        return msg;
    }
}


