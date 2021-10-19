package com.hospital.admission.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.admission.model.Admission;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        name = "Admission",
        urlPatterns = "admission/list"
)
public class AdmissionList extends BaseServlet {
    @Inject
    private DbUtilI dbUtilI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Admission> admission = new ArrayList<Admission>();
        RequestDispatcher requestDispatcher;
        Connection connection= (Connection) req.getServletContext().getAttribute("sqlcon");

        try {
            /*Statement statement= connection.createStatement();
            ResultSet resultSet= statement.executeQuery("select * from admit ");*/
            ResultSet resultSet=dbUtilI.readData("select * from admit ");
            while (resultSet.next()){
                admission.add(new Admission(resultSet.getInt(1),resultSet.getInt(6),resultSet.getString(2),
                        resultSet.getString(3),resultSet.getString(4),
                        resultSet.getString(5)));
            }
            //System.out.println("fghjklkjhgfdsdfghj"+admission.get(3).getDateOfAdmission());
            ObjectMapper objectMapper=new ObjectMapper();
            objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
            resultWrapper.setList(admission);
            //resp.setContentType("application/json");

            resp.getWriter().write(objectMapper.writeValueAsString(resultWrapper));

            /*req.setAttribute("admissiondata",admission);
            requestDispatcher=req.getRequestDispatcher("/admission.jsp");
            System.out.println("mmmmmmmmmmmmmmmmmmmmmm "+requestDispatcher);
            requestDispatcher.forward(req,resp);*/

        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
