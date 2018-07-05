package cn.tedu.cloud_note.service;

import cn.tedu.cloud_note.dao.NoteDao;
import cn.tedu.cloud_note.entity.Note;
import cn.tedu.cloud_note.util.NoteResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("noteService")
public class NoteServiceImpl implements NoteService {
    @Resource
    private NoteDao noteDao;
    public NoteResult<List<Map<String, String>>> loadBookNotes(String bookId) {
        List<Map<String, String>> list=noteDao.findByBookId(bookId);
        NoteResult<List<Map<String, String>>> result=new NoteResult<List<Map<String, String>>>();

        result.setData(list);
        result.setStatus(0);
        result.setMsg("加载异常");
        return result;
    }
    public NoteResult<Note> loadNote(String noteId) {
        Note note = noteDao.findByNoteId(noteId);
        NoteResult<Note> result = new NoteResult<Note>();
        if (note==null){
            result.setStatus(1);
            result.setMsg("未找到数据！");
            return result;
        }else{
            result.setStatus(0);
            result.setMsg("查询成功");
            result.setData(note);
            return result;
        }
    }
    public NoteResult<Object> updateNote(String noteId,String body,String tiele){
        //创建note参数
        Note note=new Note();
        note.setCn_note_id(noteId);
        note.setCn_note_body(body);
        note.setCn_note_title(tiele);
        Long time=System.currentTimeMillis();
        note.setCn_note_last_modify_time(time);
        //更新数据库记录
        int rows=noteDao.updateNote(note);
        //构造result
        NoteResult<Object> result=new NoteResult<Object>();
        if(rows==1){
            result.setStatus(0);
            result.setMsg("保存笔记成功");
        }


        return null;

    }
}
