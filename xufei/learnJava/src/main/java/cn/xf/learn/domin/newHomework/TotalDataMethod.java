package cn.xf.learn.domin.newHomework;

import cn.xf.learn.domin.BookDO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by xufei on 18-1-25
 */
@Component
@RestController
public class TotalDataMethod {
    BookDO bookDO=new BookDO();


   public  void totalMethod() throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        SpringTest springTest = (SpringTest) context.getBean("springTest");
        BookDO bookDO = new BookDO();
        bookDO.setName("name");
        bookDO.setAuthor("author");
        bookDO.setCatalogue("catalogue");
        bookDO.setIntroduction("introduction");
        Scanner sc = new Scanner(System.in);
        Boolean flag=true;
        while (flag) {
            System.out.println("请输入你要进行的操作：1.查找书籍，2.修改信息，" +
                    "3.插入书籍，4.移除书籍,5显示所有书籍，6退出");
            int number = sc.nextInt();
            sc.nextLine();
            System.out.println();
            switch (number) {
                //调用1 查找方法
                case 1:
                    System.out.println("您要实现的功能是查找");
                    System.out.println("请输入要查找的编号");
                    int bookId1 = sc.nextInt();
                    sc.nextLine();
                    System.out.println(springTest.select(bookId1));
                    System.out.println();
                    break;

                //调用2 修改信息
                case 2:
                    System.out.println("您要实现的功能是修改信息");
                    System.out.println("请输入修改信息书籍的编号");
                    int bookId2 = sc.nextInt();
                    sc.nextLine();
                    springTest.update(bookId2);
                    break;

                //调用3 插入书籍
                case 3:
                    System.out.println("您要实现的功能是插入书籍");
                    System.out.println("请输入要修改的内容部分：" + "1.书名  " + "\t" + " 2.编号  " +
                            "\t" + " 3.作者  " + "\t" + "  4.分类  " + "\t" + "5.简介");
                    System.out.println("插入书籍以逗号分隔");
                    System.out.println("---------------");
                    String content = sc.nextLine();
                    BookDO bookDO2=springTest.preInsert(content);
                    springTest.insert(bookDO2);
                    break;

                case 4:
                    System.out.println("您要实现的功能是移除书籍");
                    System.out.println("输入您移除书籍的编号");
                    System.out.println("---------------");
                    int bookId3 = sc.nextInt();
                    sc.nextLine();
                    springTest.delete(bookId3);
                    break;

                case 5:
                    System.out.println("您要输入的功能是显示全部书籍");
                    System.out.println("---------------");
                    springTest.show();
                    break;

                    //调用4 无操作结束
                default:
                    flag=false;
            }
        }
    }

}
