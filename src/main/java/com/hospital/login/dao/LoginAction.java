package com.hospital.login.dao;

import com.hospital.util.dao.DbUtilI;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

@WebServlet(
        name = "login",
        urlPatterns = "/login"
)
public class LoginAction extends HttpServlet {
    @Inject
    private DbUtilI dbUtilI;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        RequestDispatcher requestDispatcher;
        Connection connection= (Connection) req.getServletContext().getAttribute("sqlcon");
        String id=req.getParameter("staffId");
        System.out.println("kkkkkkkkkkkkkkkkkkkkkkkk "+id);


        try {
            /*Statement statement = connection.createStatement();
            ResultSet resultSet=statement.executeQuery*/
            ResultSet resultSet=dbUtilI.readData("select * from staffregister where staffid="+"'"+id+"'");
            String actualpassword = null;
            String staffName = null;
            while (resultSet.next()){
                actualpassword=resultSet.getString("password");
                staffName=resultSet.getString("name");
            }
            System.out.println("sssssssssssssssssssss  "+actualpassword);
            if (actualpassword.equals(req.getParameter("password"))){
                session.setAttribute("staffId",id);
                requestDispatcher=req.getRequestDispatcher("./index.jsp");
            }else{
                session.setAttribute("message","Invalid Login credentials");
                requestDispatcher=req.getRequestDispatcher("./login.jsp");
            }


        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("message","Invalid Login credentials");
            requestDispatcher=req.getRequestDispatcher("./login.jsp");
        }
        requestDispatcher.forward(req,resp);


    }
}
