package com.hospital.util.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

public interface DbConnectionI extends Serializable {
    Connection getConnection() throws SQLException;
}
