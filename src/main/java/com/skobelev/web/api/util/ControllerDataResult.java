package com.skobelev.web.api.util;

import java.io.Serializable;
import java.util.List;

public class ControllerDataResult extends WebResult implements Serializable {
    private List<ControllerData> controllerData;

    public ControllerDataResult(List<ControllerData> controllerData) {
        super("ok");
        this.controllerData = controllerData;
    }

    public List<ControllerData> getControllerData() {
        return controllerData;
    }

    @Override
    public String toString() {
        return "ControllerDataResult{" +
                "controllerData=" + controllerData +
                '}';
    }
}
