package com.jetherrodrigues.service;

import java.io.Serializable;

import com.jetherrodrigues.domain.Acquisition;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 
 * @author Jether Rois
 *
 */
public interface AcquisitionService extends Serializable {
	Mono<Acquisition> save(Acquisition instrument);
	Flux<Acquisition> findAll();
	Mono<Acquisition> findById(String id);
}
