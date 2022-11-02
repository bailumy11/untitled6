package jdbc.jd;

import jdbc.properties.sourceManage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Insert {

    public static void main(String[] args)throws Exception {
        String url = sourceManage.getProp("url");
        String name =sourceManage.getProp("name");
        String password =sourceManage.getProp("password");
            Connection conn = DriverManager.getConnection(url,name,password);
            Statement stmt = conn.createStatement();
            //新增学生信息
         String sql1 ="insert into students(Stuid, name, Sex,Age) VALUES (123457, '小蓝', 1,18)";
        stmt.executeUpdate(sql1);
         //新增课程信息
        String sql2 ="insert into class(time,Mon,Tues,Wed,Thur,Fri) values('14.00-16.00','化学','物理','数学','语文','英语') ";
        stmt.executeUpdate(sql2);
            //查询所有信息
        String sql3 = "select * from students"; String sql4 ="select * from class";
        ResultSet rs1 = stmt.executeQuery(sql3);
        System.out.println("学生信息:");
        while (rs1.next()) {
            System.out.print("学号:" + rs1.getString("Stuid"));
            System.out.print("; ");
            System.out.print("姓名："+rs1.getString("name"));
            System.out.print("; ");
            System.out.print("性别:" + rs1.getString("Sex"));
            System.out.print("; ");
            System.out.print("年龄:" + rs1.getInt("Age"));
            System.out.println(". ");
        }
        ResultSet rs2 = stmt.executeQuery(sql4);
        System.out.println("课程信息：");
        while (rs2.next()) {
            System.out.print("时间:" + rs2.getString("time"));
            System.out.print("; ");
            System.out.print("星期一："+rs2.getString("Mon"));
            System.out.print("; ");
            System.out.print("星期二：" + rs2.getString("Tues"));
            System.out.print("; ");
            System.out.print("星期三:" + rs2.getString("Wed"));
            System.out.print("; ");
            System.out.print("星期四:" + rs2.getString("Thur"));
            System.out.print("; ");
            System.out.print("星期五:" + rs2.getString("Fri"));
            System.out.println(". ");
        }
        rs2.close();
        rs1.close();
        stmt.close();
        conn.close();
    }

    }

