package com.hospital.finance.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.finance.model.Finances;
import com.hospital.util.BaseServlet;
import com.hospital.util.dao.DbUtilI;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        name = "ReadFinances",
        urlPatterns = "finance/list"
)

public class ReadFinance extends BaseServlet {
    @Inject
    private DbUtilI dbUtilI;
    private int patientId;
    private String service;
    private int quantity;
    private BigDecimal fee;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Finances> finances = new ArrayList<Finances>();

        try {
            ResultSet resultSet=dbUtilI.readData("select *, quantity*fee as totalFee from finances");
            while (resultSet.next()){
                finances.add(new Finances(resultSet.getInt(1),resultSet.getString(2),
                        resultSet.getInt(3),resultSet.getBigDecimal(4),resultSet.getBigDecimal(5)));
            }
            ObjectMapper objectMapper=new ObjectMapper();
            resultWrapper.setList(finances);
            resp.getWriter().write(objectMapper.writeValueAsString(resultWrapper));

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
