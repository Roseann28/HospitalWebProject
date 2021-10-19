package com.hospital.department.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.department.model.Department;
import com.hospital.util.BaseServlet;
import com.hospital.util.dao.DbUtilI;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        name = "departmentList",
        urlPatterns = "department/list"
)
public class ReadDepartment extends BaseServlet {
    @Inject
    private DbUtilI dbUtilI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Department> departments= new ArrayList<Department>();

        try {
            ResultSet resultSet=dbUtilI.readData("select * from department");
            while (resultSet.next()){
                departments.add(new Department(resultSet.getInt(1),resultSet.getString(2)));
            }
            ObjectMapper objectMapper=new ObjectMapper();
            resultWrapper.setList(departments);
            resp.getWriter().write(objectMapper.writeValueAsString(resultWrapper));

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
