package cn.xf.learn.domin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by xufei on 18-3-8
 */
public class PersonDO {
    private String readerName;  //借书人姓名

    private int readerAge;     // 借书人年龄

    private String readerSex;  //借书人性别

    private String readerType;    //借书人类型   老师  学生 其他

    private int readerStudentId;  //学生号

    private int readerTeacherId;   //教师号

    private int readerOtherId;    //借书号   不一定有，  只针对于其他无工

    private String readerId;   //身份证号码

    PersonDO(int readerOtherId,String readerName,int readerAge,String readerSex,
             String readerType,String readerId){
     setReaderOtherId(readerOtherId);
     setReaderName(readerName);
     setReaderAge(readerAge);
     setReaderSex(readerSex);
     setReaderType(readerType);
     setReaderId(readerId);


    }




    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public int getReaderAge() {
        return readerAge;
    }

    public void setReaderAge(int readerAge) {
        this.readerAge = readerAge;
    }

    public String getReaderSex() {
        return readerSex;
    }

    public void setReaderSex(String readerSex) {
        this.readerSex = readerSex;
    }

    public String getReaderType() {
        return readerType;
    }

    public void setReaderType(String readerType) {
        this.readerType = readerType;
    }

    public int getReaderStudentId() {
        return readerStudentId;
    }

    public void setReaderStudentId(int readerStudentId) {
        this.readerStudentId = readerStudentId;
    }

    public int getReaderTeacherId() {
        return readerTeacherId;
    }

    public void setReaderTeacherId(int readerTeacherId) {
        this.readerTeacherId = readerTeacherId;
    }

    public int getReaderOtherId() {
        return readerOtherId;
    }

    public void setReaderOtherId(int readerOtherId) {
        this.readerOtherId = readerOtherId;
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }


    private char readerPassword;

    private BookDO readerbookDO;








}
