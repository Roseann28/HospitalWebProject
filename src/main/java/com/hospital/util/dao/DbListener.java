package com.hospital.util.dao;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
@WebListener
public class DbListener implements ServletContextListener {

    @Resource(lookup="java:jboss/datasources/HospitalWeb")
    private DataSource dataSource;

    public void contextInitialized(ServletContextEvent sce) {

        try {
            Connection conn = dataSource.getConnection();

            ServletContext sc = sce.getServletContext();
            sc.setAttribute("sqlcon", conn);

        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext=sce.getServletContext();
        if (servletContext.getAttribute("sqlcon")!=null){
            Connection connection= (Connection) servletContext.getAttribute("sqlcon");
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
