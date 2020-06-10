package com.npcmaker;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.*;

public class DbConnector {
    public Connection connect() {

        String dbDir = "/NPCmaker/";
        File f = new File(dbDir);
        if (!f.exists()){
            f.mkdir();
        }
        String dbName = "npcmakerdb.accdb";
        String dbPath = dbDir + "/" + dbName;
        File f2 = new File(dbPath);
        if (!f2.exists()){
            InputStream iStream = DbConnector.class.getResourceAsStream("/db/"+dbName);
            try {
                Files.copy(iStream, f2.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //String dbPath = "C:\\Users\\tomas\\1dv430\\projectMain\\project\\src\\main.java.NpcMaker\\db\\npcmakerdb.accdb";
        //String dbPath = "C:\\Users\\Azmodan\\1dv430\\project\\src\\main.java.NpcMaker\\db\\npcmakerdb.accdb";
        String dbUrl = "jdbc:ucanaccess://" + dbPath;
        Connection conn;
        ResultSet rs;
        Statement s;

        try {
            conn = DriverManager.getConnection(dbUrl,"","");
            return conn;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    return null;
    }
}

