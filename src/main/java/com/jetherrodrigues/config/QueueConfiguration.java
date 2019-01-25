package com.jetherrodrigues.config;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

/**
 * @author Jether Rois
 */
@Configuration
@EnableJms 
public class QueueConfiguration {
    
    @Bean("acquisitionQueue")
    public Queue acquisitionQueue(@Value("${app.queue.acquisition}") String acquisitionQueue) {    	
        return new ActiveMQQueue(acquisitionQueue);
    }
    
    @Bean("instrumentQueue")
    public Queue instrumentQueue(@Value("${app.queue.instrument}") String instrumentQueue) {
        return new ActiveMQQueue(instrumentQueue);
    }
}