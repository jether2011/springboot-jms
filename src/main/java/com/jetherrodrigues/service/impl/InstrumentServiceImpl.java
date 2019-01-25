package com.jetherrodrigues.service.impl;

import com.jetherrodrigues.domain.Instrument;
import com.jetherrodrigues.repository.InstrumentRepository;
import com.jetherrodrigues.service.InstrumentService;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Jether Rois
 */
@Service
public class InstrumentServiceImpl implements InstrumentService {

    private static final long serialVersionUID = 1L;
    
    private InstrumentRepository repository;

    public InstrumentServiceImpl(InstrumentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Instrument> save(Instrument instrument) {
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

}