package com.hospital.appointment.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.appointment.model.Book;
import com.hospital.util.BaseServlet;
import com.hospital.util.dao.DbUtilI;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@WebServlet(
        name = "viewAppointment",
        urlPatterns = "/appointment/view"
)
public class ReadAppointment extends BaseServlet {
    @Inject
    private DbUtilI dbUtilI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection= (Connection) req.getServletContext().getAttribute("sqlcon");
        RequestDispatcher requestDispatcher;
        List<Book> book=new ArrayList<Book>();
        try {
            /*Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery*/
            ResultSet resultSet=dbUtilI.readData("select * from book ");
            while (resultSet.next()) {
                book.add(new Book(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getInt(4), resultSet.getInt(7),resultSet.getString(5),resultSet.getString(6),resultSet.getString(8)));
            }
            /*req.getSession().setAttribute("bookdata",book);
            requestDispatcher=req.getRequestDispatcher("/BookList.jsp");
            requestDispatcher.forward(req,resp);
            Cookie cookie=new Cookie("cookiebook",book.get(0).getName());
            resp.addCookie(cookie);*/
            ObjectMapper objectMapper=new ObjectMapper();
            resultWrapper.setList(book);
            //resp.setContentType("application/json");
            resp.getWriter().write(objectMapper.writeValueAsString(resultWrapper));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
