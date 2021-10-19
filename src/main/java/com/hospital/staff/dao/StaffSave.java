package com.hospital.staff.dao;

import com.hospital.util.dao.DbUtilI;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(
        name ="Staffsave",
        urlPatterns ="staffs/save"
)

public class StaffSave extends HttpServlet {
    @Inject
    private DbUtilI dbUtilI;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection= (Connection) req.getServletContext().getAttribute("sqlcon");
        RequestDispatcher requestDispatcher;


        //if (connection!=null){
            try {

                String query = "insert into staff(name,department,specialisation) values("
                               +"'" + req.getParameter("name")+"'," +
                        "'" + req.getParameter("department")+"',"+ "'" + req.getParameter("specialisation")+"')";
                System.out.println("ttttttttttttttttttttttttttttttt "+query);
                dbUtilI.writeData(query);


            } catch (SQLException e) {
                e.printStackTrace();
            }
            resp.sendRedirect("../index.jsp");

        }/*else {
            resp.sendRedirect("/staffs/form");
        }*/
    }


