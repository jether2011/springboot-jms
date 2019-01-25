package com.jetherrodrigues.jms;

/**
 * @author Jether Rois
 */
public abstract class AbstractConsumer<T> {	
	public abstract void consume(T t);
}