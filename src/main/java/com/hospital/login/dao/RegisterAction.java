package com.hospital.login.dao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(
        name = "Register",
        urlPatterns = "/register"
)
public class RegisterAction extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection= (Connection) req.getServletContext().getAttribute("sqlcon");
        RequestDispatcher requestDispatcher;


        if (connection!=null){
            try {
                String q="insert into staffregister(password,name,staffid) values ("+"'"+req.getParameter("pass")+"',"+
                        "'"+req.getParameter("name")+"',"+"'"+req.getParameter("staffId")+"')";
                System.out.println(q);
                Statement statement = connection.createStatement();
                statement.executeUpdate(q);


            } catch (SQLException e) {
                e.printStackTrace();
            }
            resp.sendRedirect("./login.jsp");

        }else {
            resp.sendRedirect("./register");
        }

    }

}
