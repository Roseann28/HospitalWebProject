package com.hospital.patients.dao;



import com.hospital.patients.bean.CheckId;
import com.hospital.patients.model.Patient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
@WebServlet(
        name = "orderPatients",
        urlPatterns = "/order"
)
public class OrderPatients extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = (Connection) req.getServletContext().getAttribute("sqlcon");
        Cookie cookie[]=req.getCookies();
        String ida=cookie[0].getValue();
        System.out.println(ida);
        CheckId checkId=new CheckId();

        try {
                String id = req.getParameter("id") ;
                String table;
                if (checkId.queryId(id)){
                    table="book";
                }else {
                    table="patient";
                }
                String query="insert into orderpatients(id,name,dateOfBirth,specialist,doctor,paymentmethod)select id,name,dateOfBirth,specialist,doctor,paymentmethod from "+table+" where id=";
            System.out.println(query);

                Statement statement = connection.createStatement();
                statement.executeUpdate(query+"'"+id+"'");

        } catch (SQLException e) {
                e.printStackTrace();
            }
        resp.sendRedirect("./DoctorList.jsp");


        }
    }
