package com.hospital.test.dao;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.test.model.Tests;
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
        name = "Testlist",
        urlPatterns = "test/list"
)
public class TestList extends BaseServlet {
    @Inject
    private DbUtilI dbUtilI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Tests> tests = new ArrayList<Tests>();
        RequestDispatcher requestDispatcher;
        Connection connection= (Connection) req.getServletContext().getAttribute("sqlcon");

        try {
           /* Statement statement= connection.createStatement();
            ResultSet resultSet= statement.executeQuery(*/
            ResultSet resultSet=dbUtilI.readData("select * from test");
            while (resultSet.next()){
                tests.add(new Tests(resultSet.getInt(1),resultSet.getInt(4),resultSet.getString(2),
                        resultSet.getString(3)));
            }
            /*req.setAttribute("testdata",tests);
            requestDispatcher=req.getRequestDispatcher("/test.jsp");
            System.out.println("mmmmmmmmmmmmmmmmmmmmmm "+requestDispatcher);
            requestDispatcher.forward(req,resp);*/
            ObjectMapper objectMapper=new ObjectMapper();
            resultWrapper.setList(tests);
            //resp.setContentType("application/json");
            resp.getWriter().write(objectMapper.writeValueAsString(resultWrapper));

        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
