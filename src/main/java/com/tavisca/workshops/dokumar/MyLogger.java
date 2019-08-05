package com.tavisca.workshops.dokumar;

import java.io.IOException;
import java.util.logging.*;

public class log {
    static Logger logger= LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static  void logMessage(String message){
        try {
            FileHandler fileHandler= new FileHandler("logFile.txt",true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.log(Level.INFO,message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
