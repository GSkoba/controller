import storage.MySqlStorage;
import util.Controller;
import util.ControllerData;

import java.io.FileInputStream;
import java.util.ArrayList;
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
        System.out.println(mySqlStorage.getBooksCount());
        List<Controller> controllers = mySqlStorage.getController();

        for (Controller elem: controllers
             ) {
            System.out.println(elem);
        }

        List<ControllerData> controllerData = mySqlStorage.getAllData();
        for (ControllerData elem: controllerData
             ) {
            System.out.println(elem);
        }

        Controller controllerTom = new Controller(10,"tom");
        Controller controllerTest = new Controller(1,"test");
        mySqlStorage.authController(controllerTom);
        mySqlStorage.authController(controllerTest);

    }

}
