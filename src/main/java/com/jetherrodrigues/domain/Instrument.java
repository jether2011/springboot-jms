package com.jetherrodrigues.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public final class Instrument implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    @Indexed(unique=true)
    private String name;
    @Indexed(unique=true)
    private String code;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime created;

    public Instrument() {
        this.created = LocalDateTime.now();
    }
    
    public Instrument name(String name) {
        this.name = name;
        return this;
    }

    public Instrument code(String code) {
        this.code = code;
        return this;
    }

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
    }
}