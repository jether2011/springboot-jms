package com.jetherrodrigues.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

import com.jetherrodrigues.domain.Instrument;
import com.jetherrodrigues.service.InstrumentService;

/**
 * @author Jether Rois
 */
@Component
public class InstrumentJmsConsumer extends AbstractConsumer<Instrument> {
    
    private static Logger logger = LoggerFactory.getLogger(InstrumentJmsConsumer.class);

    private InstrumentService instrumentService;

    public InstrumentJmsConsumer(InstrumentService instrumentService) {
        this.instrumentService = instrumentService;
    }

    /**
	 * This method consume the instrument queue
	 * If some error occurs when try to save the instrument on database, it will consume again until the successes.
	 * @param instrument is the instrument to be saved in the database.
	 * **/
	@JmsListener(destination = "${app.queue.instrument}")
    @Override
    public void consume(Instrument instrument) {
        try {
            Mono<Instrument> created = instrumentService.save(instrument);   
            logger.info("Mono instrument {} was consumed by instrument consumer and created into datyabse.", 
                created
                    .blockOptional()
                    .get());
        } catch (Exception e) {
            logger.error("an error occurred when trying to save the instrument {}.", instrument, e);
			throw e;
        }        
    }
}