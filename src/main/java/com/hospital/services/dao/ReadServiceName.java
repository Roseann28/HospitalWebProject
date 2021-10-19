package com.hospital.services.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.services.model.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@WebServlet(
        name = "serviceName",
        urlPatterns = "/serviceName"
)

public class ReadServiceName extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Service> serviceNames = new ArrayList<Service>();
        Connection connection = (Connection) req.getServletContext().getAttribute("sqlcon");
        RequestDispatcher requestDispatcher;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from service ");
            while (resultSet.next()) {
                serviceNames.add(new Service(resultSet.getString(1)));
            }
           /* req.getSession().setAttribute("names",serviceNames);*/
            /*requestDispatcher=req.getRequestDispatcher("/FinanceForm.jsp");
            System.out.println("mmmmmmmmmmmmmmmmmmmmmm "+serviceNames);*/
            /*requestDispatcher.forward(req,resp);*/
            ObjectMapper objectMapper=new ObjectMapper();
            //resp.setContentType("application/json");
            resp.getWriter().write(objectMapper.writeValueAsString(serviceNames));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
