package com.hospital.basicMeasurements.action;

import com.hospital.basicMeasurements.bean.BmiConversion;
import com.hospital.basicMeasurements.dao.AddBasicMeasurement;
import com.hospital.basicMeasurements.model.BasicMeasurements;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BmiAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        calculateBmi(req);
    }
    public double calculateBmi(HttpServletRequest req) {
        AddBasicMeasurement addBasicMeasurement=new AddBasicMeasurement();
        BasicMeasurements basicMeasurements=new BasicMeasurements();
        BasicMeasurements basic=addBasicMeasurement.populateObject(req,basicMeasurements);
        BmiConversion bmiConversion =new BmiConversion();
        double bmiResult= bmiConversion.conversionResult(basic.getWeight(),basic.getHeight(),basic.getWeightUnit(),basic.getHeightUnit());
        return bmiResult;
    }
}
