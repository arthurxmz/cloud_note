package test.dao;

import cn.tedu.cloud_note.entity.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestBookDao {
    //定义参数
    String[] conf={"conf/spring-mvc.xml",
                "conf/spring-mybatis.xml"};
    //实例化
    ApplicationContext ctx
            =new ClassPathXmlApplicationContext(conf);
    @Test
    public void testDao(){
        BookDao dao
                =ctx.getBean("bookDao",BookDao.class);
        List<Book> list=dao.findByUserId("52f9b276-38ee-447f-a3aa-0d54e7a736e4");
        for (Book book:list){
            System.out.println(book.getCn_notebook_id()+","+
                    book.getCn_notebook_name());
        }
    }
}
