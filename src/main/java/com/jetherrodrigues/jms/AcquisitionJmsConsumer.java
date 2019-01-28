package com.jetherrodrigues.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

import com.jetherrodrigues.domain.Acquisition;
import com.jetherrodrigues.service.AcquisitionService;

/**
 * @author Jether Rois
 */
@Component
public class AcquisitionJmsConsumer extends AbstractConsumer<Acquisition> {
    
    private static Logger logger = LoggerFactory.getLogger(AcquisitionJmsConsumer.class);

    private AcquisitionService acquisitionService;

    public AcquisitionJmsConsumer(AcquisitionService acquisitionService) {
        this.acquisitionService = acquisitionService;
    }

    /**
	 * This method consume the acquisition queue
	 * If some error occurs when try to save the acquisition on database, it will consume again until the successes.
	 * @param acquisition is the acquisition to be saved in the database.
	 * **/
	@JmsListener(destination = "${app.queue.acquisition}")
    @Override
    public void consume(Acquisition acquisition) {
        try {
            Mono<Acquisition> created = acquisitionService.save(acquisition);               
            logger.info("acquisition {} was consumed by acquisition consumer.", 
                created
                    .blockOptional()
                    .get());
        } catch (Exception e) {
            logger.error("an error occurred when trying to save the acquisition {}.", acquisition, e);
			throw e;
        }        
    }
}