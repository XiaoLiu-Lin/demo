package com.example.demo.service.ex2;

/**
 * Exception 测试用户查询异常
 */
public class SelectException extends InsertException {

    private static final long serialVersionUID = 5390007656984952382L;


    public SelectException() {
        super();
    }

    public SelectException(String message) {
        super(message);
    }

    public SelectException(String message, Throwable cause) {
        super(message, cause);
    }

    public SelectException(Throwable cause) {
        super(cause);
    }

    public SelectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
