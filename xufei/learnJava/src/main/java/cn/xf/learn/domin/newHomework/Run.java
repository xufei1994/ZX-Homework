package cn.xf.learn.domin.newHomework;

import cn.xf.learn.domin.BookDO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xufei on 18-1-25
 */
public class Run {
    void run(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        SpringTest springTest = (SpringTest) context.getBean("springTest");
        BookDO bookDO = new BookDO();
        bookDO.setName("name");
        bookDO.setAuthor("author");
        bookDO.setCatalogue("catalogue");
        bookDO.setIntroduction("introduction");

    }
}
