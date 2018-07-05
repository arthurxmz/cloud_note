package test.dao;

import cn.tedu.cloud_note.dao.NoteDao;
import cn.tedu.cloud_note.entity.Note;
import org.junit.Before;
import org.junit.Test;
import test.service.TestBase;

import java.util.List;
import java.util.Map;

public class TestNoteDao extends TestBase {
    private NoteDao noteDao;
    @Before
    public void init(){
        noteDao=super.getContext().getBean("noteDao",NoteDao.class);

    }
    @Test
    public void testNoteDao(){
        List<Map<String, String>> list =noteDao.findByBookId("163e1c76-0461-4122-930f-47f36fdf0ebe");
        for (Map note:list){
            System.out.println(note.get("cn_note_id")+","+note.get("cn_note_title"));
        }
    }
    @Test
    public void testFind(){
        String noteId=
                "019cd9e1-b629-4d8d-afd7-2aa9e2d6afe0";
        Note note=
        noteDao.findByNoteId(noteId);
        System.out.println(note.getCn_note_id());
        System.out.println(note.getCn_note_title());

    }
    @Test
    public void testUpadate(){
        Note note=new Note();
        String noteId=
                "019cd9e1-b629-4d8d-afd7-2aa9e2d6afe0";
        note.setCn_note_id(noteId);
        String title="传奇克星";
        note.setCn_note_title(title);
        String body="已经到达巅峰";
        note.setCn_note_body(body);
        Long time=System.currentTimeMillis();
        note.setCn_note_create_time(time);
        int num=noteDao.updateNote(note);
        System.out.println(num);


    }
}
