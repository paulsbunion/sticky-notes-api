package com.defrain.stickynotesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.defrain.stickynotesapi.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {

}
