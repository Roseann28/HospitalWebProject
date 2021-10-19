package com.hospital.util.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface DbUtilI {
    ResultSet readData(String query) throws SQLException;
    boolean writeData(String query) throws SQLException;
    boolean deleteData(String table,int id) throws SQLException;
}
