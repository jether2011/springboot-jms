package com.jetherrodrigues.resource;

import java.io.Serializable;

import javax.validation.Valid;

import com.jetherrodrigues.domain.Instrument;
import com.jetherrodrigues.response.MessageResponse;
import com.jetherrodrigues.service.InstrumentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping(API + V1 + INSTRUMENT)
public class InstrumentResource implements Serializable {

    private static final long serialVersionUID = 1L;

    private InstrumentService instrumentService;

    public InstrumentResource(InstrumentService instrumentService) {
        this.instrumentService = instrumentService;
    }

    /**
	 * GET /all : get a list of instruments.
	 *  
	 * @return 200 - OK and Flux of Instrument
	 */
	@GetMapping("/all")
    public Flux<Instrument> findAll() {
        return this.instrumentService.findAll();
    }

    /**
	 * GET /{id} : get the instrument by ID.
	 * 
	 * @param id - String id	 
	 * 
	 * @return 200 - OK and Mono of Instrument
	 */
	@GetMapping("{id}")
	public Mono<Instrument> findById(@PathVariable String id) {
		return this.instrumentService.findById(id);
    }
    
    /**
	 * POST / : persist the instrument in the queue.
	 * 
	 * @param instrument - Instrument
	 * 
	 * @return 200 - OK
	 */
    @PostMapping    
    public ResponseEntity<MessageResponse> save(@Valid @RequestBody Instrument instrument) {
        instrumentService.produce(instrument);
        return ResponseEntity.ok().body(new MessageResponse(HttpStatus.OK, "The object was saved into the Queue: " + instrument));
    }
}