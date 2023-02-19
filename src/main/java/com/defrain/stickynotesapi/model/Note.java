package com.defrain.stickynotesapi.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Note {
	
	public Note() {};

	public Note(Long id, LocalDateTime created, String text) {
		this.id = id;
		this.createdDateTime = created;
		this.text = text;
	}

	@Id
	@GeneratedValue
	private Long id;

	@CreationTimestamp
	private LocalDateTime createdDateTime;
//	
//	@UpdateTimestamp
	private LocalDateTime updatedDateTime;

	@Lob
	private String text;

	public Long getId() {
		return id;
	}

	public void setId(Long id) { this.id = id; }
	 
	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public LocalDateTime getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "{id=" + id + ", createdDateTime=" + createdDateTime + ", updatedDateTime=" + updatedDateTime + ", text="
				+ text + "}";
	}

}
