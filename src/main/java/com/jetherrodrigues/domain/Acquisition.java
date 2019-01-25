package com.jetherrodrigues.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Jether Rois
 */
@Document(collection = "acquisitions")
public final class Acquisition implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private Double value;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created;

    @DBRef
    private Instrument instrument;
    
    public Acquisition() {
        this.created = LocalDateTime.now();
    }

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
    }
    
    public void setValue(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return this.value;
    }

    public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
    }
    
    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public Instrument getInstrument() {
        return this.instrument;
    }
}