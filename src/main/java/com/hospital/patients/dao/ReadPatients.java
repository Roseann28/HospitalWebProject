package com.hospital.patients.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.patients.model.Patient;
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
        name = "Patientlistupdate",
        urlPatterns = "/patient/list"
)

public class ReadPatients extends BaseServlet {
    @Inject
    private DbUtilI dbUtilI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = (Connection) req.getServletContext().getAttribute("sqlcon");
        getPatientsRecords(req, resp, connection);

    }

    public List<Patient> getPatientsRecords(HttpServletRequest req, HttpServletResponse resp, Connection connection) {
        RequestDispatcher requestDispatcher;
        List<Patient> patients = new ArrayList<Patient>();

        try {
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery
              ResultSet resultSet=dbUtilI.readData("select * from patient ");
            while (resultSet.next()) {
                patients.add(new Patient(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getInt(4), resultSet.getString(5),resultSet.getString(7),
                        resultSet.getString(8),resultSet.getDate(6)));
            }
            System.out.println("yyyyyyyyyy"+patients.get(5).getDateOfBirth());
            /*req.setAttribute("patientdata",patients);
            requestDispatcher= req.getRequestDispatcher("/PatientList.jsp");
            System.out.println("mmmmmmmmmmmmmmmmmmmmmm "+requestDispatcher);
            requestDispatcher.forward(req, resp);*/
            ObjectMapper objectMapper=new ObjectMapper();
            resultWrapper.setList(patients);
            //resp.setContentType("application/json");
            resp.getWriter().write(objectMapper.writeValueAsString(resultWrapper));


        } catch (Exception e) {
            e.printStackTrace();

        }
        return patients;

    }


}

