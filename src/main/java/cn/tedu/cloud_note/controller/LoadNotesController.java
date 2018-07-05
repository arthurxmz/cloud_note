package cn.tedu.cloud_note.controller;

import cn.tedu.cloud_note.service.NoteService;
import cn.tedu.cloud_note.util.NoteResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping(value = "/note")
public class LoadNotesController {
    @Resource
    private NoteService noteService;
    @RequestMapping(value = "loadnotes.do")
    @ResponseBody
    public NoteResult<List<Map<String,String>>> execute(String bookId){
        NoteResult<List<Map<String,String>>> result=noteService.loadBookNotes(bookId);
            return result;
    }

}
