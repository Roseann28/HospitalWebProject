package com.hospital.patients;/*
package com.cohort.nine.patients;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@WebServlet(
        name = "PatientSearch",
        urlPatterns = "/search"
)
public class PatientSearch extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter display = resp.getWriter();
         <html>  
         <head>  
         <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"    
                 integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">    
                "    
                 <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">  
         <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU\" crossorigin=\"anonymous\">  
         </head>  
         <body>


         <h3>Patients Search</h3>     
                           
                      <form action=\"./search\" method=\"POST\">    

         <hr/>  
           <label for=\"namelabel\">Patient Id:</label><br>     
                        <input type=\"text\" id=\"id\" name=\"id\"><br>    

         <input type=\"submit\" value=\"Submit\">     
                      </form>   



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> patients = new ArrayList<String>();
        Connection connection = (Connection) req.getServletContext().getAttribute("sqlcon  
        RequestDispatcher requestDispatcher;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select patient.id,name,test,findings,admit,dateOfAdmission from patient left join ailment on patient.id=ailment.patientid left join test on patient.id=test.patientid left join admit on patient.id=admit.patientid left join basic on patient.id=basic.id where patient.id="+req.getParameter("id"));
            while (resultSet.next()) {
                patients.add(resultSet.getString(1));
                patients.add(resultSet.getString(2));
                patients.add(resultSet.getString(3));
                patients.add(resultSet.getString(4));
                patients.add(resultSet.getString(5));
                patients.add(resultSet.getString(6));
            }
            req.setAttribute("searchdata",patients);
            requestDispatcher=req.getRequestDispatcher("/search.jsp  
            System.out.println("mmmmmmmmmmmmmmmmmmmmmm "+requestDispatcher);
            requestDispatcher.forward(req,resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
*/
