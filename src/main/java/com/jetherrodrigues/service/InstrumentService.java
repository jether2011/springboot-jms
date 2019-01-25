package com.jetherrodrigues.service;

import java.io.Serializable;

import com.jetherrodrigues.domain.Instrument;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 
 * @author Jether Rois
 *
 */
public interface InstrumentService extends Serializable {
	Mono<Instrument> save(Instrument instrument);
	Flux<Instrument> findAll();
	Mono<Instrument> findById(String id);
	void produce(Instrument instrument);
}
