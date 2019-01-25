package com.jetherrodrigues.repository;

import com.jetherrodrigues.domain.Acquisition;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Jether Rois
 */
@Repository
public interface AcquisitionRepository extends ReactiveMongoRepository<Acquisition, String> {

}