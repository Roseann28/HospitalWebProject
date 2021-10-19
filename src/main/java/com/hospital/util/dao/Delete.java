package com.hospital.util.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import netscape.javascript.JSObject;
import org.json.JSONObject;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(
        name = "deleteData",
        urlPatterns = "delete/data"
)

public class Delete extends HttpServlet {
    @Inject
    private DbUtilI dbUtilI;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //int[] deleteArrayExcute= (int[]) req.getSession().getAttribute("deleteArray");
        /*String deleteArrayExcute=req.getParameter("arrays");
        System.out.println(deleteArrayExcute);
        for (int i=0;i<deleteArrayExcute.length();i++){
            try {
                dbUtilI.deleteData("admit",i);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }*/
        //List<DeleteObject>deleteObjects=new ArrayList<DeleteObject>();
        System.out.println("yyyyyyyyyyyy"+req.getParameter("ids"));
        ObjectMapper objectMapper=new ObjectMapper();
        //objectMapper.readValue(deleteObjects);
        //JsonObject jsonObject=new JSObject(getB);
        String jsonBody = new BufferedReader(new InputStreamReader(req.getInputStream())).lines().collect(
                Collectors.joining("\n"));
        if (jsonBody == null || jsonBody.trim().length() == 0) {
            // return error that jsonBody is empty
        }

        // this parses the incoming json to a json object.
        //JsonObject jsonObject=new JSObject(jsonBody);
        jsonBody=jsonBody.replace("[", "").replace("]", "");

        JSONObject jObj = new JSONObject(jsonBody);
        System.out.println("eeeeeeeeeeeeeee"+jObj);
        Object obj = null;
        Iterator<String> deleteObjects=jObj.keys();
        while (deleteObjects.hasNext()){
            String key = deleteObjects.next();
            obj=jObj.get(key);
            System.out.println(obj);
        }
        String ids=String.valueOf(obj);
        int intid=Integer.valueOf(ids);

        System.out.println("jjjj"+intid);
        try {
            dbUtilI.deleteData("admit",intid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /*for (DeleteObject deleteObject:deleteObjects){
            System.out.println("oooooooooooo "+deleteObject.getDeleteid());

        }*/
        /*System.out.println("iiiiiiiiiiiiiiii"+deleteObjects.get(0).getDeleteid());
        System.out.println("kkkkk"+req.getParameter("ab"));
        System.out.println("hhhh"+req.getParameter("names"));*/


        resp.sendRedirect("../index.jsp");

    }
}
