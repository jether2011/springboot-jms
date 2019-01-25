package com.jetherrodrigues.service.impl;

import com.jetherrodrigues.domain.Acquisition;
import com.jetherrodrigues.exception.ServiceUnavaliableException;
import com.jetherrodrigues.jms.AbstractProducer;
import com.jetherrodrigues.jms.AcquisitionJmsProducer;
import com.jetherrodrigues.repository.AcquisitionRepository;
import com.jetherrodrigues.service.AcquisitionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Jether Rois
 */
@Service
public class AcquisitionServiceImpl implements AcquisitionService {

    private static final long serialVersionUID = 1L;
    private static Logger logger = LoggerFactory.getLogger(AcquisitionServiceImpl.class);

    private AcquisitionRepository repository;
    private AbstractProducer<Acquisition> abstractProducer;

    public AcquisitionServiceImpl(AcquisitionRepository repository, AcquisitionJmsProducer acquisitionJmsProducer) {
        this.repository = repository;
        this.abstractProducer = acquisitionJmsProducer;
    }

    @Override
    public Mono<Acquisition> save(Acquisition acquisition) {
        return this.repository.save(acquisition);
    }

    @Override
    public Flux<Acquisition> findAll() {
        return this.repository.findAll();
    }

	@Override
	public Mono<Acquisition> findById(String id) {
		return this.repository.findById(id);
	}

    @Override
    public void produce(Acquisition acquisition) {
        try {
            abstractProducer.produce(acquisition);
        } catch (Exception e) {
            logger.error("An error occurs when trying produce the acquisition {}", acquisition, e);
			throw new ServiceUnavaliableException("An error occurs when trying produce the acquisition");
        }
    }
}