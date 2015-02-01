package com.company.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.expression.common.TemplateAwareExpressionParser;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.util.Calendar;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{

    static PlatformTransactionManager transactionManager;
    static JdbcTemplate template;

    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        DataSource source  = (DataSource)context.getBean("dataSource");
        template = new JdbcTemplate();
        template.setDataSource(source);

        transactionManager = (DataSourceTransactionManager)context.getBean("transactionManager");

        String SQL = "select count(*) from main.Student;";
        int rows = template.queryForInt(SQL);
        System.out.println(rows);


        SQL = "update student set name = ? where id = ?";
        template.update(SQL, new Object[]{ "Luke - new name", 1 });


        SQL = "select * from Student where id = ?";
        Student student = template.queryForObject(SQL, new Object[]{1}, new StudentMapper());
        System.out.println(student.toString());


        createStudentWithMarks();

    }


    public static  void createStudentWithMarks(){

        String name = "new user";
        int age = 10;
        int marks = 10;
        int year = Calendar.getInstance().get(Calendar.YEAR);

        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);

        try {
            String SQL1 = "insert into Student (name, age) values (?, ?)";
            template.update( SQL1, name, age);

            // Get the latest student id to be used in Marks table
            String SQL2 = "select max(id) from Student";
            int sid = template.queryForInt( SQL2 );

            String SQL3 = "insert into Marks(sid, marks, year) " +
                    "values (?, ?, ?)";
            template.update( SQL3, sid, marks, year);

            System.out.println("Created Name = " + name + ", Age = " + age);
            transactionManager.commit(status);
        } catch (DataAccessException e) {
            System.out.println("Error in creating record, rolling back");
            transactionManager.rollback(status);
            throw e;
        }

    }
}
