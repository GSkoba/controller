package com.skobelev.web.api.service;

import com.skobelev.web.api.controller.MainController;
import com.skobelev.web.api.storage.MySqlStorage;
import com.skobelev.web.api.util.ControllerData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import com.skobelev.web.api.util.Controller;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

@Service("mainService")
public class MainService {
    private static Properties properties = new Properties();
    private static String url;
    private static String user;
    private static String password;
    private MySqlStorage mySqlStorage = new MySqlStorage(url, user, password);

    static {
        try {
            properties.load(new FileInputStream("src/main/resources/config.properties"));
            url = properties.getProperty("db.url");
            user = properties.getProperty("db.login");
            password = properties.getProperty("db.password");
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public List<Controller> getController() {
        return mySqlStorage.getController();
    }

    public List<ControllerData> getAllData() {
        return mySqlStorage.getAllData();
    }
}
