package com.defrain.stickynotesapi.controller;

import static com.defrain.stickynotesapi.JSON.asJsonString;
import static org.mockito.ArgumentMatchers.any;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.defrain.stickynotesapi.model.Note;
import com.defrain.stickynotesapi.service.INoteService;

@WebMvcTest(controllers = NoteController.class)
@ExtendWith(SpringExtension.class)
class NoteControllerTests {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	INoteService noteService;
	
	Note testNote;
	Note updateNote;
	
	@BeforeEach
	public void setup() {
		testNote = new Note(123l, LocalDateTime.of(2023, 1, 1, 12, 30), "A Note");
		updateNote = new Note(123l, LocalDateTime.of(2023, 1, 1, 12, 30), "Updated Note");
	}
	
	@Test
	void testGetAllNotes() throws Exception {
		given(noteService.getAllNotes())
			.willReturn(Arrays.asList(testNote));
		
		mockMvc.perform(get("/notes"))
		.andDo(print())
		.andExpect(status().is2xxSuccessful())
		.andExpect(jsonPath("$").isArray())
		.andExpect(jsonPath("$[*].id").value(123));
	}
	
	@Test
	void testUpdateNote() throws Exception {
		given(noteService.updateNote(any(Note.class)))
			.willReturn(updateNote);
		
		mockMvc.perform(put("/notes/" + testNote.getId())
				.content(asJsonString(testNote))
				.contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().is2xxSuccessful())
			.andExpect(jsonPath("$.id").value(123))
			.andExpect(jsonPath("$.text").value("Updated Note"));
	}
	
	@Test
	void testCreateNote() throws Exception {
		given(noteService.saveNote(any(Note.class)))
			.willReturn(testNote);
		
		mockMvc.perform(post("/notes")
				.content(asJsonString(testNote))
				.contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().is2xxSuccessful())
			.andExpect(jsonPath("$.id").value(123))
			.andExpect(jsonPath("$.text").value("A Note"));
	}

}
