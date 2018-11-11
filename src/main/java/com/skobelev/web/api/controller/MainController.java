package com.skobelev.web.api.controller;

import com.skobelev.web.api.service.MainService;
import com.skobelev.web.api.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@RestController
public class MainController {

    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    @Autowired
    MainService mainService;

    @RequestMapping("/test")
    public String greeting() {
        return "Hi!";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/controllers", headers = "Accept=application/json;charset=UTF-8")
    @ResponseBody
    public WebResult getControllers(HttpServletResponse response) {
        try {
            log.info("getControllers::start");
            return new ControllerResult(mainService.getController());
        } catch (IllegalArgumentException e) {
            log.error("Error: ", e);
            response.setStatus(400);
            return new WebResult(e.getMessage());
        } catch (Exception e) {
            log.error("Error: ", e);
            response.setStatus(500);
            return new WebResult(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/controllers-data", headers = "Accept=application/json;charset=UTF-8")
    @ResponseBody
    public WebResult getControllerData(HttpServletResponse response) {
        try {
            log.info("getControllerData::start");
            return new ControllerDataResult(mainService.getAllData());
        } catch (IllegalArgumentException e) {
            log.error("Error: ", e);
            response.setStatus(400);
            return new WebResult(e.getMessage());
        } catch (Exception e) {
            log.error("Error: ", e);
            response.setStatus(500);
            return new WebResult(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/upload-data", headers = "Accept=application/json;charset=UTF-8")
    @ResponseBody
    public WebResult uploadData(
            @RequestParam(value = "id_controller") int idController,
            @RequestParam(value = "name") String nameController,
            @RequestParam(value = "weither") String weither,
            @RequestParam(value = "time_controller") int timeController,
            @RequestParam(value = "disc") String disc,
            HttpServletResponse response) {
        try {
            Controller controller = new Controller(idController, nameController);
            ControllerData controllerData = new ControllerData(idController, weither, new Date(timeController), disc);
            log.info("uploadData::start");
            return uploadData(controller, controllerData, response);
        } catch (IllegalArgumentException e) {
            log.error("Error: ", e);
            response.setStatus(400);
            return new WebResult(e.getMessage());
        } catch (Exception e) {
            log.error("Error: ", e);
            response.setStatus(500);
            return new WebResult(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/upload-data", headers = "Accept=application/json;charset=UTF-8")
    @ResponseBody
    public WebResult uploadData(
            @RequestBody Controller controller,
            @RequestBody ControllerData controllerData,
            HttpServletResponse response) {
        try {
            log.info("uploadData::start");
            mainService.uploadData(controller, controllerData);
            return new WebResult("ok");
        } catch (IllegalArgumentException e) {
            log.error("Error: ", e);
            response.setStatus(400);
            return new WebResult(e.getMessage());
        } catch (Exception e) {
            log.error("Error: ", e);
            response.setStatus(500);
            return new WebResult(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get-controller-data", headers = "Accept=application/json;charset=UTF-8")
    @ResponseBody
    public WebResult getControllerData(
            @RequestParam(value = "id") int id,
            HttpServletResponse response) {
        try {
            log.info("uploadData::start");
            return getControllerData(new Controller(id), response);
        } catch (IllegalArgumentException e) {
            log.error("Error: ", e);
            response.setStatus(400);
            return new WebResult(e.getMessage());
        } catch (Exception e) {
            log.error("Error: ", e);
            response.setStatus(500);
            return new WebResult(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/get-controller-data", headers = "Accept=application/json;charset=UTF-8")
    @ResponseBody
    public WebResult getControllerData(
            @RequestBody Controller controller,
            HttpServletResponse response) {
        try {
            log.info("uploadData::start");
            return new ControllerDataResult(mainService.getControllerData(controller));
        } catch (IllegalArgumentException e) {
            log.error("Error: ", e);
            response.setStatus(400);
            return new WebResult(e.getMessage());
        } catch (Exception e) {
            log.error("Error: ", e);
            response.setStatus(500);
            return new WebResult(e.getMessage());
        }
    }
}
