package test.service;


import cn.tedu.cloud_note.service.UserService;
import cn.tedu.cloud_note.util.NoteResult;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestUserserivce {

    UserService service;

    @Before
    public void init(){
        String[] conf = {
                "conf/spring-mvc.xml",
                "conf/spring-mybatis.xml"};
        ApplicationContext ac =
                new ClassPathXmlApplicationContext(conf);
         service = ac.getBean(
                "userService",UserService.class);
    }



    @Test
    public void test1(){
        System.out.println(service.getClass().getName());
        NoteResult result =
                service.checkLogin("demo",
                        "c8837b15473ce0991");
        System.out.println(result.getStatus());
        System.out.println(result.getMsg());
        System.out.println(result.getData());
    }
    @Test    //用列-4：预期结果：注册成功
    public void test4(){
        String name="苍老师";
        String password="123456";
        String desc="二蛋";
        NoteResult<Object> result=service.addUser(name,password,desc);
        
        System.out.println(result.getStatus());
        System.out.println(result.getMsg());
    }


}
