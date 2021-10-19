package com.hospital.basicMeasurements.dao;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.basicMeasurements.model.BasicMeasurements;
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
        name = "Basicslist",
        urlPatterns = "/basics/list"
)
public class ReadBasic extends BaseServlet {
    @Inject
    private DbUtilI dbUtilI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        selectDetails(req, resp);


    }

    private BasicMeasurements selectDetails(HttpServletRequest req, HttpServletResponse resp) {
        List<BasicMeasurements> basicMeasurements = new ArrayList<BasicMeasurements>();
        RequestDispatcher requestDispatcher;
        Connection connection= (Connection) req.getServletContext().getAttribute("sqlcon");
        BasicMeasurements basicMeasurement=new BasicMeasurements();
        try {
            /*Statement statement= connection.createStatement();
            ResultSet resultSet= statement.executeQuery*/
            ResultSet resultSet=dbUtilI.readData("select * from basic ");

            while (resultSet.next()){
                basicMeasurements.add(new BasicMeasurements(resultSet.getInt(1),
                        resultSet.getDouble(2),resultSet.getDouble(3),
                        resultSet.getString(4),resultSet.getDouble(5)));
            }
            /*req.setAttribute("basicdata", basicMeasurements);
            requestDispatcher= req.getRequestDispatcher("/basic.jsp");
            System.out.println("mmmmmmmmmmmmmmmmmmmmmm "+requestDispatcher);
            requestDispatcher.forward(req, resp);*/
            ObjectMapper objectMapper=new ObjectMapper();
            resultWrapper.setList(basicMeasurements);
            //resp.setContentType("application/json");
            resp.getWriter().write(objectMapper.writeValueAsString(resultWrapper));

        }catch (Exception e){
            e.printStackTrace();
        }
        return basicMeasurement;
    }
}
