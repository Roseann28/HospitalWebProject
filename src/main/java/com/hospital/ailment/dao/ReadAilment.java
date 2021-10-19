package com.hospital.ailment.dao;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.ailment.model.Ailment;
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
        name = "Ailmentlist",
        urlPatterns = "ailment/list"
)
public class ReadAilment extends BaseServlet {
    @Inject
    private DbUtilI dbUtilI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Ailment> ailments = new ArrayList<Ailment>();
        RequestDispatcher requestDispatcher;

        Connection connection= (Connection) req.getServletContext().getAttribute("sqlcon");

        try {
            /*Statement statement= connection.createStatement();
            ResultSet resultSet= statement.executeQuery(*/
            ResultSet resultSet=dbUtilI.readData("select * from ailment");
            while (resultSet.next()){
                ailments.add(new Ailment(resultSet.getInt(6),resultSet.getInt(5),
                        resultSet.getString(1),resultSet.getString(2),
                        resultSet.getString(3),resultSet.getString(4)));
            }
            /*req.setAttribute("ailmentdata",ailments);
            requestDispatcher=req.getRequestDispatcher("/ailment.jsp");
            System.out.println("mmmmmmmmmmmmmmmmmmmmmm "+requestDispatcher);
            requestDispatcher.forward(req,resp);*/
            ObjectMapper objectMapper=new ObjectMapper();
            resultWrapper.setList(ailments);
            //resp.setContentType("application/json");
            resp.getWriter().write(objectMapper.writeValueAsString(resultWrapper));

        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
