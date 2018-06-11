package cn.tedu.cloud_note.dao;

import cn.tedu.cloud_note.entity.Book;

import java.util.List;

public interface BookDao {
    //通过Id来查找
   public List<Book> findByUserId(String userId);


}
