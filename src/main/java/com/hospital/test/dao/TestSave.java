package com.hospital.test.dao;

import com.hospital.test.model.Tests;
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
        name = "Test",
        urlPatterns = "test/save"
)

public class TestSave extends HttpServlet {
    @Inject
    private DbUtilI dbUtilI;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection= (Connection) req.getServletContext().getAttribute("sqlcon");
        RequestDispatcher requestDispatcher;
        Tests test=new Tests();


        //if (connection!=null){
            try {
                test.setLabTechId((Integer) req.getSession().getAttribute("staffId"));
                BeanUtils.populate(test,req.getParameterMap());
                String query = "insert into test(testname,findings,patientId,labTechnicianId) values("
                        +"'" +test.getTestName()+"',"
                        +"'" +test.getFinding()+"'," +
                        test.getPatientId()+","+
                        test.getLabTechId()+" )";
                dbUtilI.writeData(query);
                System.out.println(query);
                /*Statement statement = connection.createStatement();
                statement.executeUpdate(query);*/


            } catch (SQLException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            resp.sendRedirect("../index.jsp");

        }/*else {
            resp.sendRedirect("/test/form");
        }

    }*/

}

