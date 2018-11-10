package com.skobelev.web.api.util;

import java.io.Serializable;
import java.util.List;

public class ControllerResult extends WebResult implements Serializable {
    private List<Controller> controllers;

    public ControllerResult(List<Controller> controllers) {
        super("ok");
        this.controllers = controllers;
    }

    public List<Controller> getControllers() {
        return controllers;
    }

    @Override
    public String toString() {
        return "ControllerResult{" +
                "controllers=" + controllers +
                '}';
    }
}
