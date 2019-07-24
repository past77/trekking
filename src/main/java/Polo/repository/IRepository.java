package Polo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IRepository{

    void create(Object... args) throws SQLException;

    ResultSet read(int id) throws SQLException;

    void delete(int id) throws SQLException;

    int update(Object... args) throws SQLException;
}
