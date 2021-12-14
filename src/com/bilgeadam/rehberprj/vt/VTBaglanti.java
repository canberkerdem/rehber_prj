package com.bilgeadam.rehberprj.vt;

import java.sql.*;

public class VTBaglanti {


    public static Connection baglantiGetir() throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection conn=
                DriverManager.getConnection("jdbc:postgresqlÇ//localhost:5432/rehber","postgres","POSTGRES");
        return conn;
    }

    public static void baglantiKapat(Connection conn) throws SQLException {
        conn.close();
    }
}
