package com.jetherrodrigues.config;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
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

    @Bean
    public ConnectionFactory getActiveMQConnectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("vm://localhost?broker.persistent=false");      
        // activeMQConnectionFactory.setBrokerURL("tcp://0.0.0.0:61616");  
        // activeMQConnectionFactory.setUserName("admin");
        // activeMQConnectionFactory.setPassword("admin");
        activeMQConnectionFactory.setTrustAllPackages(true);

        return activeMQConnectionFactory;
    }
}