package com.jetherrodrigues.jms;

import javax.jms.Queue;

import com.jetherrodrigues.domain.Instrument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author Jether Rois
 */
@Component
public class InstrumentJmsProducer extends AbstractProducer<Instrument> {
    
    @Autowired
    public InstrumentJmsProducer(@Qualifier("instrumentQueue") Queue queue) {
        super(queue);
    }
}