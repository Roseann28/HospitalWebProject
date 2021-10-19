package com.hospital.basicMeasurements.dao;

import com.hospital.basicMeasurements.action.BmiAction;
import com.hospital.basicMeasurements.model.BasicMeasurements;
import com.hospital.util.dao.DbUtilI;
import org.apache.commons.beanutils.BeanUtils;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(
        name = "Basic",
        urlPatterns ="/basics/save"
)
public class AddBasicMeasurement extends HttpServlet {
    @Inject
    private DbUtilI dbUtilI;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = (Connection) req.getServletContext().getAttribute("sqlcon");
        RequestDispatcher requestDispatcher;
        BasicMeasurements basicMeasurements = new BasicMeasurements();
        basicMeasurements=populateObject(req,basicMeasurements);
        BmiAction bmiAction=new BmiAction();
        basicMeasurements.setBmi(bmiAction.calculateBmi(req));

        //if (connection != null) {
            try {

                String query = "insert into basic(id,height,weight,bloodpressure,BMI)values(" + basicMeasurements.getId() + "," +
                        basicMeasurements.getHeight() + "," +
                        basicMeasurements.getWeight() + ",'" + basicMeasurements.getBloodPressure() + "',"+
                        basicMeasurements.getBmi()+")";
                dbUtilI.writeData(query);
                System.out.println("@@@@@@@@@@@@ " + query);
                /*Statement statement = connection.createStatement();
                statement.executeUpdate(query);*/
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resp.sendRedirect("../index.jsp");

        } /*else {
            resp.sendRedirect("/basics/form");
        }

    }*/
    public BasicMeasurements populateObject(HttpServletRequest req, BasicMeasurements basicMeasurements){
        try {
            BeanUtils.populate(basicMeasurements,req.getParameterMap());
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return basicMeasurements;
    }


    }
