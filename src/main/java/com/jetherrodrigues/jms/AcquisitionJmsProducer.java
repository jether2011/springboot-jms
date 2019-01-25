package com.jetherrodrigues.jms;

import javax.jms.Queue;

import com.jetherrodrigues.domain.Acquisition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author Jether Rois
 */
@Component
public class AcquisitionJmsProducer extends AbstractProducer<Acquisition> {
    
    @Autowired
    public AcquisitionJmsProducer(@Qualifier("acquisitionQueue") Queue queue) {
        super(queue);
    }
}