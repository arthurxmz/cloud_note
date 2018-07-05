package cn.tedu.cloud_note.service;

import cn.tedu.cloud_note.entity.Note;
import cn.tedu.cloud_note.util.NoteResult;


import java.util.List;
import java.util.Map;

public interface NoteService {
    NoteResult<List<Map<String, String>>> loadBookNotes(String bookId);

    NoteResult<Note> loadNote(String noteId);

    NoteResult<Object> updateNote(String noteId,String title,String body);
}
