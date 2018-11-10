package com.skobelev.web.api.util;

import java.util.Date;

public class ControllerData {
    private int id;
    private int id_controller;
    private String weither;
    private Date time_controller;
    private Date time_server;
    private String disc;

    public ControllerData() {
    }

    public ControllerData(int id, int id_controller, String weither, Date time_controller, Date time_server, String disc) {
        this.id = id;
        this.id_controller = id_controller;
        this.weither = weither;
        this.time_controller = time_controller;
        this.time_server = time_server;
        this.disc = disc;
    }

    public int getId() {
        return id;
    }

    public int getId_controller() {
        return id_controller;
    }

    public String getWeither() {
        return weither;
    }

    public Date getTime_controller() {
        return time_controller;
    }

    public Date getTime_server() {
        return time_server;
    }

    public String getDisc() {
        return disc;
    }

    @Override
    public String toString() {
        return "ControllerData{" +
                "id=" + id +
                ", id_controller=" + id_controller +
                ", weither='" + weither + '\'' +
                ", time_controller=" + time_controller +
                ", time_server=" + time_server +
                ", disc='" + disc + '\'' +
                '}';
    }
}
