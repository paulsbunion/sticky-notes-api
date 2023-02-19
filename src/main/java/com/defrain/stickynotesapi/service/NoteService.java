package com.defrain.stickynotesapi.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defrain.stickynotesapi.model.Note;
import com.defrain.stickynotesapi.repository.NoteRepository;

@Service
public class NoteService implements INoteService {
	
	@Autowired
	NoteRepository noteRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(NoteService.class);

	@Override
	public List<Note> getAllNotes() {
		logger.info("getAllNotes NoteService called");
		return noteRepository.findAll();
	}

	@Override
	public Note updateNote(Note note) throws Exception {
		logger.info("updateNote for id: {} in NoteService called", note.getId());
		boolean exists = noteRepository.existsById(note.getId());
		if (exists) {
			Note oldNote = noteRepository.findById(note.getId()).get();
			oldNote.setText(note.getText());
			oldNote.setUpdatedDateTime(LocalDateTime.now());
			note = oldNote;
		} else {
			
		}
		return noteRepository.save(note);
	}

	@Override
	public Note saveNote(Note note) {
		logger.info("saveNote in NoteService called");
		return noteRepository.save(note);
	}

}
