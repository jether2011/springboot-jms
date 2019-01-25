package com.jetherrodrigues.exception;

/**
 * @author Jether Rois
 */
public final class ServiceUnavaliableException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ServiceUnavaliableException(String message) {
        super(message);
    }
}