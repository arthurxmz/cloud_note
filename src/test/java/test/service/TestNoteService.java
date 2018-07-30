package test.service;

import cn.tedu.cloud_note.entity.Note;
import cn.tedu.cloud_note.service.NoteService;
import cn.tedu.cloud_note.util.NoteResult;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class TestNoteService extends TestBase {
    private NoteService noteService;
    @Before
    public void init(){
        noteService = super.getContext().getBean("noteService",NoteService.class);
    }
    @Test
    public void test(){
        NoteResult<List<Map<String,String>>> result=
                noteService.loadBookNotes("163e1c76-0461-4122-930f-47f36fdf0ebe");
        System.out.println(result.getMsg());

        System.out.println(result.getStatus());

    }
    @Test
    public void testShow(){
        NoteResult<Note> result=
        noteService.loadNote("019cd9e1-b629-4d8d-afd7-2aa9e2d6afe0");
        System.out.println(result.getStatus());
        System.out.println(result.getData());
        System.out.println(result.getMsg());
    }
    @Test
    public void testUpdate(){
        String id="019cd9e1-b629-4d8d-afd7-2aa9e2d6afe0";
        String title="Java笔记";
        String body="JDBC开发";
        NoteResult<Object> result= noteService.updateNote(id,title,body);
        System.out.println(result);
    }
}
