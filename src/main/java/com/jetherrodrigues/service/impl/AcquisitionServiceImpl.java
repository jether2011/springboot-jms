package com.jetherrodrigues.service.impl;

import com.jetherrodrigues.domain.Acquisition;
import com.jetherrodrigues.repository.AcquisitionRepository;
import com.jetherrodrigues.service.AcquisitionService;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Jether Rois
 */
@Service
public class AcquisitionServiceImpl implements AcquisitionService {

    private static final long serialVersionUID = 1L;

    private AcquisitionRepository repository;

    public AcquisitionServiceImpl(AcquisitionRepository repository) {
        this.repository = repository;
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

}