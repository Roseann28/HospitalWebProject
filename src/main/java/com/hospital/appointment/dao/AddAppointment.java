package com.hospital.appointment.dao;

import com.hospital.appointment.model.Book;
import jdk.internal.joptsimple.util.DateConverter;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(
        name = "saveAppointment",
        urlPatterns = "/appointment/save"
)
public class AddAppointment extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection connection= (Connection) req.getServletContext().getAttribute("sqlcon");
        RequestDispatcher requestDispatcher;
        Book book=new Book();

        try {

            BeanUtils.populate(book, req.getParameterMap());
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/YYYY");
            Date dob=simpleDateFormat.parse(book.getDateOfBirth());
            String dobTwo=simpleDateFormat.format(dob);
            book.setDateOfBirth(dobTwo);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        if (connection!=null){
            try {
                String query = "insert into book(name,email,age,identificationNumber,currentlocation,paymentmethod,dateOfBirth) values("
                        + "'"+book.getName()+"'," + "'" + book.getEmail() + "'," +
                        "'" + book.getAge() + "'," +  book.getNationalId() + ","
                        +"'"+ book.getLocation() +"'," +"'"+ book.getPaymentMethod()+"',"+"'"+ book.getDateOfBirth()+"')";
                System.out.println(query);
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);



            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("done");

        }else {
            System.out.println("not inserted");
        }

    }

    }
