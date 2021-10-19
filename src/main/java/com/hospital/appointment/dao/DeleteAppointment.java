package com.hospital.appointment.dao;

import com.hospital.appointment.model.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;


@WebServlet(
        name = "deleteAppointment",
        urlPatterns = "appointment/delete"
)
public class DeleteAppointment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection= (Connection) req.getServletContext().getAttribute("sqlcon");
        RequestDispatcher requestDispatcher;
        /*int id= Integer.parseInt(req.getParameter("id"));*/
        Book book=new Book();
        book.setId(req.getParameter("id"));


        try {
            String query="delete from book where id="+"'"+book.getId()+"'";
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            //requestDispatcher=req.getRequestDispatcher("/BookList.jsp");
            //requestDispatcher.forward(req,resp);
            resp.sendRedirect("./view");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
