package com.hospital.department.dao;

import com.hospital.department.model.Department;
import com.hospital.util.dao.DbUtilI;
import org.apache.commons.beanutils.BeanUtils;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
@WebServlet(
        name = "DepartmentSave",
        urlPatterns = "departments/save"
)
public class SaveDepartment extends HttpServlet {
    @Inject
    private DbUtilI dbUtilI;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Department department=new Department();

        try {
            BeanUtils.populate(department,req.getParameterMap());
            String query = "insert into department(name) values("
                    +"'" + department.getDepertmentName() +"')";
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

    }
}
