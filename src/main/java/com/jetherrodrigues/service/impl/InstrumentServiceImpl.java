package com.jetherrodrigues.service.impl;

import com.jetherrodrigues.domain.Instrument;
import com.jetherrodrigues.exception.ServiceUnavaliableException;
import com.jetherrodrigues.jms.AbstractProducer;
import com.jetherrodrigues.jms.InstrumentJmsProducer;
import com.jetherrodrigues.repository.InstrumentRepository;
import com.jetherrodrigues.service.InstrumentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Jether Rois
 */
@Service
public class InstrumentServiceImpl implements InstrumentService {

    private static final long serialVersionUID = 1L;
    private static Logger logger = LoggerFactory.getLogger(InstrumentServiceImpl.class);
    
    private InstrumentRepository repository;
    private AbstractProducer<Instrument> abstractProducer;

    public InstrumentServiceImpl(InstrumentRepository repository, InstrumentJmsProducer instrumentJmsProducer) {
        this.repository = repository;
        this.abstractProducer = instrumentJmsProducer;
    }

    @Override
    public Mono<Instrument> save(Instrument instrument) {
        logger.info("Instrument to save: {}", instrument);
        return this.repository.save(instrument);
    }

    @Override
    public Flux<Instrument> findAll() {
        return this.repository.findAll();
    }

	@Override
	public Mono<Instrument> findById(String id) {
		return this.repository.findById(id);
	}

    @Override
    public void produce(Instrument instrument) {
        try {
            abstractProducer.produce(instrument);
        } catch (Exception e) {
            logger.error("An error occurs when trying produce the instrument {}", instrument, e);
			throw new ServiceUnavaliableException("An error occurs when trying produce the instrument");
        }
    }

}