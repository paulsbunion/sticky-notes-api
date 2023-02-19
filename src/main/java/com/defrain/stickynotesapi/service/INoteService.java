package com.defrain.stickynotesapi.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.defrain.stickynotesapi.model.Note;

public interface INoteService {
	
	public List<Note> getAllNotes();
	
	public Note updateNote(Note note) throws Exception;

	public Note saveNote(Note note);
}
