package com.jetherrodrigues.repository;

import com.jetherrodrigues.domain.Instrument;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Jether Rois
 */
@Repository
public interface InstrumentRepository extends ReactiveMongoRepository<Instrument, String> {

}