package com.hospital.patients.dao;

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
        name = "Patientsaveupdate",
        urlPatterns = "/patient/save"
)

public class SavePatients extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection= (Connection) req.getServletContext().getAttribute("sqlcon");
        RequestDispatcher requestDispatcher;


        if (connection!=null){
            try {
                String query = "insert into patient(name,email,identificationNumber,paymentmethod,dateOfBirth,specialist,doctor) values("
                              +"'"+req.getParameter("name")+"',"+"'"+req.getParameter("email")+ "'," +
                         Integer.valueOf(req.getParameter("nId"))+","+"'"
                        + req.getParameter("pMethod")+"',"+"'"+req.getParameter("dob")+"',"+
                        "'"+req.getParameter("specialist")+"',"+"'"+req.getParameter("doctor")+"')";
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);


            } catch (SQLException e) {
                e.printStackTrace();
            }
            resp.sendRedirect("../index.jsp");

        }else {
            resp.sendRedirect("./patient/form");
        }

    }

}
