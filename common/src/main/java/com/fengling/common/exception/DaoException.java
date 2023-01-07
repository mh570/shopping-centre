package com.fengling.common.exception;

/**
 * 数据库异常
 */
public class DaoException extends RuntimeException {
    public DaoException(String message) {
        super(message);
    }
    public DaoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
