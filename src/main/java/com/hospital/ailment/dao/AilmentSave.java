package com.hospital.ailment.dao;

import com.hospital.ailment.model.Ailment;
import org.apache.commons.beanutils.BeanUtils;

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
import java.sql.Statement;

@WebServlet(
        name = "AilmentSave",
        urlPatterns = "ailment/save"
)
public class AilmentSave extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection= (Connection) req.getServletContext().getAttribute("sqlcon");
        RequestDispatcher requestDispatcher;
        Ailment ailment=new Ailment();


        if (connection!=null){
            try {
                ailment.setDoctorId((Integer) req.getSession().getAttribute("staffId"));
                BeanUtils.populate(ailment,req.getParameterMap());
                String query="insert into ailment(doctorid,patientid,sickness,drugs,test,admit)values("+ailment.getDoctorId()
                        +","+ailment.getPatientId()+","+"'"+ailment.getAilment()+"',"+"'"+ailment.getMedicine()+"',"
                        +"'"+ailment.getTest()+"',"+"'"+ailment.getAdmitted()+"')";
                System.out.println(";;;;;;;;;;;;;;;;;;;"+query);
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);
                } catch (SQLException e) {
                e.printStackTrace();
                } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            resp.sendRedirect("../staffHome.jsp");
            }else {
            resp.sendRedirect("/ailment/form");
            }

    }

}
