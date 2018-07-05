package cn.tedu.cloud_note.controller;

import cn.tedu.cloud_note.entity.Book;
import cn.tedu.cloud_note.service.BookService;
import cn.tedu.cloud_note.util.NoteResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/book")

public class LoadBookController {
    @Resource
    private BookService bookService;
    @ResponseBody
    @RequestMapping(value = "/loadbooks.do")
    public NoteResult<List<Book>> execute(String userId){
        NoteResult<List<Book>> result=
                bookService.loadUserBooks(userId);
        return result;
    }
}
