package com.hospital.util.dao;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil<T> implements DbUtilI{
    @Inject
    @Hospital
    private DbConnectionI dbConnectionI;

    @Override
    public ResultSet readData(String query) throws SQLException {

        Statement statement= dbConnectionI.getConnection().createStatement();
        ResultSet resultSet=statement.executeQuery(query);

        return resultSet;
    }

    @Override
    public boolean writeData(String query) throws SQLException {
        Statement statement = dbConnectionI.getConnection().createStatement();
        int i=statement.executeUpdate(query);
        return i==1;
    }

    @Override
    public boolean deleteData(String table,int id) throws SQLException {
        Statement statement = dbConnectionI.getConnection().createStatement();
        String query="Delete from "+table+" where patientid=";
        System.out.println("lllllllllllllll"+query);
        int i=statement.executeUpdate(query+id);

        return i==1;
    }
}
