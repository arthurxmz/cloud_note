package cn.tedu.cloud_note.dao;

import java.util.List;
import java.util.Map;

public interface ShareNoteDao  {
    List<Map<String, String>> findByNoteId(String NoteId);
}
