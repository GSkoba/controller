package com.skobelev.web.api;

import com.skobelev.web.api.storage.MySqlStorage;
import com.skobelev.web.api.util.Controller;
import com.skobelev.web.api.util.ControllerData;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

public class Main {
   private static Properties properties = new Properties();
   private static String url;
   private static String user;
   private static String password;

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


    public static void main(String args[]) {
        MySqlStorage mySqlStorage = new MySqlStorage(url, user, password);

    }

}
