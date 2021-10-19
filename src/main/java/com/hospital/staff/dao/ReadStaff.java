package com.hospital.staff.dao;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.staff.model.Staff;
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
        name = "stafflist",
        urlPatterns = "staffs/list"
)
public class ReadStaff extends BaseServlet {
    @Inject
    private DbUtilI dbUtilI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Staff> staff = new ArrayList<Staff>();
        RequestDispatcher requestDispatcher;
        Connection connection= (Connection) req.getServletContext().getAttribute("sqlcon");


        try {
            /*Statement statement= connection.createStatement();
            ResultSet resultSet= statement.executeQuery(*/
            ResultSet resultSet=dbUtilI.readData("select * from staff");
            while (resultSet.next()){
                staff.add(new Staff(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),
                        resultSet.getString(4)));
            }
            /*req.setAttribute("staffdata",staff);
            requestDispatcher=req.getRequestDispatcher("/staffList.jsp");
            System.out.println("mmmmmmmmmmmmmmmmmmmmmm "+requestDispatcher);
            requestDispatcher.forward(req,resp);*/
            ObjectMapper objectMapper=new ObjectMapper();
            resultWrapper.setList(staff);
            //resp.setContentType("application/json");
            resp.getWriter().write(objectMapper.writeValueAsString(resultWrapper));


        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
