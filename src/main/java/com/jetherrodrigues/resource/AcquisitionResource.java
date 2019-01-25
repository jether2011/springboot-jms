package com.jetherrodrigues.resource;

import java.io.Serializable;

import javax.validation.Valid;

import com.jetherrodrigues.domain.Acquisition;
import com.jetherrodrigues.response.MessageResponse;
import com.jetherrodrigues.service.AcquisitionService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.jetherrodrigues.util.Constants.*;
/**
 * @author Jether Rois
 */
@RestController
@RequestMapping(API + V1 + ACQUISITION)
@EnableAsync
public class AcquisitionResource implements Serializable {

    private static final long serialVersionUID = 1L;

    private AcquisitionService acquisitionService;

    public AcquisitionResource(AcquisitionService acquisitionService) {
        this.acquisitionService = acquisitionService;
    }

    /**
	 * GET /all : get a list of acquisitions.
	 *  
	 * @return 200 - OK and Flux of Acquisition
	 */
	@GetMapping("/all")
    public Flux<Acquisition> findAll() {
        return this.acquisitionService.findAll();
    }

    /**
	 * GET /{id} : get the acquisition by ID.
	 * 
	 * @param id - String id	 
	 * 
	 * @return 200 - OK and Mono of Acquisition
	 */
	@GetMapping("{id}")
	public Mono<Acquisition> findById(@PathVariable String id) {
		return this.acquisitionService.findById(id);
    }
    
    /**
	 * POST / : persist the acquisition in the queue.
	 * 
	 * @param acquisition - Acquisition
	 * 
	 * @return 200 - OK
	 */
	@PostMapping
    @Async
    public ResponseEntity<MessageResponse> save(@Valid @RequestBody Acquisition acquisition) {
        acquisitionService.produce(acquisition);
        return ResponseEntity.ok().body(new MessageResponse(HttpStatus.OK, "The object was saved into the Queue"));
    }
}