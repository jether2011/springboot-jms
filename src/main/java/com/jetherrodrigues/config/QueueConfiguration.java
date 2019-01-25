package com.jetherrodrigues.config;

import java.util.Arrays;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;
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
    	Queue queue = new ActiveMQQueue(acquisitionQueue);
        return queue;
    }
    
    @Bean("instrumentQueue")
    public Queue instrumentQueue(@Value("${app.queue.instrument}") String instrumentQueue) {
        return new ActiveMQQueue(instrumentQueue);
    }
    
    @Bean
    public ConnectionFactory getActiveMQConnectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL("tcp://0.0.0.0:61616");
        activeMQConnectionFactory.setUserName("admin");
        activeMQConnectionFactory.setPassword("admin");
        activeMQConnectionFactory.setTrustedPackages(Arrays.asList("com.jetherrodrigues.domain","java.util"));
        
        RedeliveryPolicy redeliveryPolicy = new RedeliveryPolicy();
        redeliveryPolicy.setInitialRedeliveryDelay(0);
        redeliveryPolicy.setRedeliveryDelay(60000);
        redeliveryPolicy.setUseExponentialBackOff(true);
        redeliveryPolicy.setMaximumRedeliveries(-1);
        activeMQConnectionFactory.setRedeliveryPolicy(redeliveryPolicy);

        return activeMQConnectionFactory;
    }
}