package com.defrain.stickynotesapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.defrain.stickynotesapi.model.Note;
import com.defrain.stickynotesapi.service.INoteService;

@RestController
public class NoteController {
	
	@Autowired
	INoteService noteService;
	
	private static final Logger logger = LoggerFactory.getLogger(NoteController.class);
	
	@GetMapping("/notes")
	public ResponseEntity<List<Note>> getAllNotes() {
		logger.info("getAllNotes called from NoteController");
		noteService.getAllNotes().forEach(System.out::println);
		return ResponseEntity.ok().body(noteService.getAllNotes());
	}
	
	@PostMapping("/notes")
	public ResponseEntity<Note> createNote(@RequestBody Note note) {
		logger.info("createNote called from NoteController");
		return ResponseEntity.ok().body(noteService.saveNote(note));
	}
	
	@PutMapping("/notes/{id}")
	public ResponseEntity updateNote(@PathVariable("id") Long id, @RequestBody Note note) {
		logger.info("updateNote with id: {} called from NoteController", id);
		try {
			note.setId(id);
			return ResponseEntity.ok().body(noteService.updateNote(note));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ResponseEntity.badRequest().body("Error");
	}
	
	
}
