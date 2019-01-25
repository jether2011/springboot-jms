package com.jetherrodrigues.exception;

/**
 * @author Jether Rois
 */
public final class InstrumentNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InstrumentNotFoundException(String message) {
        super(message);
    }
}