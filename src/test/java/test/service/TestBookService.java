package test.service;

import cn.tedu.cloud_note.entity.Book;
import cn.tedu.cloud_note.service.BookService;
import cn.tedu.cloud_note.util.NoteResult;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestBookService extends TestBase {
    private BookService bookService;
    @Before
    public void init(){
        bookService=
        super.getContext().getBean(
                "bookSerivce",BookService.class);
    }
    @Test
    public void test(){
        NoteResult<List<Book>> result=
                bookService.loadUserBooks("52f9b276-38ee-447f-a3aa-0d54e7a736e4");
        System.out.println(result.getStatus());
        System.out.println(result.getMsg());
        System.out.println(result.getData());
        for(Book book:result.getData()){
            System.out.println(
                    book.getCn_notebook_name());
        }
    }

}
