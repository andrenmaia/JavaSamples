package com.company.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        DataSource source  = (DataSource)context.getBean("dataSource");
        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(source);

        String SQL = "select count(*) from main.Student;";
        int rows = template.queryForInt(SQL);
        System.out.println(rows);


        SQL = "update student set name = ? where id = ?";
        template.update(SQL, new Object[]{ "Luke - new name", 1 });


        SQL = "select * from Student where id = ?";
        Student student = template.queryForObject(SQL, new Object[]{1}, new StudentMapper());
        System.out.println(student.toString());

    }
}
