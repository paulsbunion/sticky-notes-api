package com.defrain.stickynotesapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.defrain.stickynotesapi.model.Note;
import com.defrain.stickynotesapi.service.INoteService;

@RestController
public class Controller {
	
	@Autowired
	INoteService noteService;
	
	@GetMapping("/")
	public ResponseEntity<String> getStuff() {
		System.err.println("called f'n");
		List<Note> notesList = noteService.getAllNotes();
		return new ResponseEntity(notesList, HttpStatus.OK);
	}

}
