package test.dao;

import cn.tedu.cloud_note.dao.UserDao;
import cn.tedu.cloud_note.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserdao {

    @Test
    public void testUserDao() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "conf/spring-mybatis.xml");

        UserDao dao
                = ctx.getBean("userDao", UserDao.class);
        User user = dao.findByName("test1");

        System.out.println(user);
    }
    @Test
    public void testSave(){
        String[] conf
                ={"conf/spring-mvc.xml",
                    "conf/spring-mybatis.xml"};
        //实例化ctx对象
        ApplicationContext ctx
                =new ClassPathXmlApplicationContext(conf);
        //获取UserDao对象
        UserDao dao=ctx.getBean("userDao",UserDao.class);
        User user = new User();
        user.setCn_user_id("1234567891");
        user.setCn_user_name("张三灯");
        user.setCn_user_password("123456");
        user.setCn_user_desc("帅");
        
        dao.save(user);
        System.out.println(user);
    }
}
