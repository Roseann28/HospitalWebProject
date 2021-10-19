package com.hospital.admission.dao;

import com.hospital.admission.model.Admission;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

@WebServlet(
        name = "AdmitSave",
        urlPatterns = "admission/save"
)

public class AdmissionSave extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection= (Connection) req.getServletContext().getAttribute("sqlcon");
        RequestDispatcher requestDispatcher;
        Admission admission=new Admission();


        if (connection!=null){
            try {
                /*BeanUtils.populate(admission,req.getParameterMap());
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("/yyyy/MM/dd");
                Date doa=simpleDateFormat.parse(admission.getDateOfAdmission());
                String doaTwo=simpleDateFormat.format(doa);
                admission.setDateOfAdmission(doaTwo);

                Date present=simpleDateFormat.parse(admission.getPresentDate());
                String presentTwo=simpleDateFormat.format(present);
                admission.setPresentDate(presentTwo);*/
                admission.setStaffId((Integer) req.getSession().getAttribute("staffId"));
                String query="insert into admit(roomnumber,dateOfAdmission,presentdate,progress,patientId,staffId)values("
                        +"'"+req.getParameter("roomNumber")+"',"+"'"+ req.getParameter("dateOfAdmission") +"',"+
                        "'"+req.getParameter("presentDate")+"',"
                        +"'"+req.getParameter("progress")+"',"+req.getParameter("patientId")+","+admission.getStaffId()+")";
                System.out.println("aaaaaaaaaaaaaa "+query);
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);
            } catch (Exception e) {
                e.printStackTrace();
            }
            resp.sendRedirect("../index.jsp");
        }else {
            resp.sendRedirect("/admission/form");
        }


    }
}
