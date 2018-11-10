package com.skobelev.web.api.storage;

import com.skobelev.web.api.util.Controller;
import com.skobelev.web.api.util.ControllerData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlStorage {
    private String url;
    private String user;
    private String password;
    private static Connection con;
    private static Statement stmt;
    private static PreparedStatement statement;
    private static ResultSet rs;

    public MySqlStorage(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public List<Controller> getController() {
        String query = "select * from controller;";
        List<Controller> controllerList = new ArrayList<>();
        Controller controller = null;
        int id = 0;
        String name = "";
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                id = rs.getInt(1);
                name = rs.getString(2);
                controller = new Controller(id, name);
                controllerList.add(controller);
            }
            return controllerList;
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                stmt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                rs.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return new ArrayList<>();
    }

    public List<ControllerData> getAllData() {
        String query = "select * from controller_data;";
        List<ControllerData> controllerList = new ArrayList<>();
        ControllerData controllerData = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                controllerData = new ControllerData(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getTime(4),
                        rs.getTime(5),
                        rs.getString(6)
                );
                controllerList.add(controllerData);
            }
            return controllerList;
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                stmt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                rs.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return new ArrayList<>();
    }

    private boolean containsController(int id, List<Controller> controllers){
        for (Controller controller: controllers
             ) {
            if (controller.getId() == id) return true;
        }
        return false;
    }

    public void authController(Controller controller){
        List<Controller> controllers = getController();
        if (containsController(controller.getId(), controllers)){
            return;
        } else {
            String query = "insert into controller(id, controller_name) value(?,?);";
            try {
                con = DriverManager.getConnection(url, user, password);
                statement = con.prepareStatement(query);
                statement.setInt(1,controller.getId());
                statement.setString(2,controller.getName());
                statement.executeUpdate();
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
                try {
                    statement.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
    }
}
