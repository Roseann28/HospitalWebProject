package com.hospital.services.dao;

import com.hospital.services.model.Service;
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
        name = "SaveService",
        urlPatterns = "/service/save"
)
public class SaveService extends HttpServlet {
    @Inject
    private DbUtilI dbUtilI;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection= (Connection) req.getServletContext().getAttribute("sqlcon");
        RequestDispatcher requestDispatcher;
        Service service=new Service();


        //if (connection!=null){
            try {
                BeanUtils.populate(service,req.getParameterMap());
                String query = "insert into service(name,quantity,price) values("
                              +"'"+service.getName()+"'," + service.getQuantity() +"," +
                         service.getPrice() +")";
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
            resp.sendRedirect("/service/add");
        }
    }*/
}
