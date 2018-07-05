package cn.tedu.cloud_note.controller;

import cn.tedu.cloud_note.entity.Note;
import cn.tedu.cloud_note.service.NoteService;
import cn.tedu.cloud_note.util.NoteResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/note")

public class LoadNoteController {
    @Resource
    private    NoteService noteService;
    @ResponseBody
    @RequestMapping(value = "/load.do")
    public NoteResult<Note> execute (String noteId){
        NoteResult<Note> result=noteService.loadNote(noteId);
        return result;
    }
}
