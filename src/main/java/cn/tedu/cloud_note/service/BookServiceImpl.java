package cn.tedu.cloud_note.service;

import cn.tedu.cloud_note.dao.BookDao;
import cn.tedu.cloud_note.entity.Book;
import cn.tedu.cloud_note.entity.User;
import cn.tedu.cloud_note.util.NoteResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("bookService")
public class BookServiceImpl implements BookService {
    @Resource
    private BookDao bookDao;
    public NoteResult<List<Book>> loadUserBooks(String userId){

        List<Book> list=bookDao.findByUserId(userId);
        //构造返回结果result
        NoteResult<List<Book>> result=new NoteResult<List<Book>>();
        result.setStatus(0);
        result.setMsg("查询成功");
        result.setData(list);
        return result;
    }
}
