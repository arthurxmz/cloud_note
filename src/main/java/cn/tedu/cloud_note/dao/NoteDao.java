package cn.tedu.cloud_note.dao;



import cn.tedu.cloud_note.entity.Note;

import java.util.List;
import java.util.Map;

public interface NoteDao {
    List<Map<String, String>> findByBookId(String bookId);

    Note findByNoteId(String noteId);

    int updateNote(Note note);
}
