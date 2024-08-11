package org.helpdesk.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AbstractDAO {
    public static Connection connect() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "helpdesk";
        String password = "123456789";
        Connection c = DriverManager.getConnection(url, username, password);
        return c;

    }
}
