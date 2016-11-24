package com.arjun.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * This class have two method first save propertis in XML format
 * another method use for get properties to XML file
 * @author NIC
 *
 */
public class ReadAndWritePropertiesXML {
    /**
     * Create instance of simple java logger.
     */
    private static final Logger LOGGER = Logger.getLogger(ReadProperties.class.getName());

    public static void main(String[] args) {
        // Method call to save data.
        saveParamChangesAsXML(AppConstants.SERVER_ADDRESS, AppConstants.SERVER_PORT, AppConstants.NUMBER_OF_THREADS, LOGGER, AppConstants.FILE_LOCATION_XML);
        // Method call to get data.
        ReadParamXML();
    }
    /**
     * This method use serverAddr,serverPort,threadCnt,LOGGER and fileLocation as string parameter.
     * @param serverAddr
     * @param serverPort
     * @param threadCnt
     * @param LOGGER
     * @param fileLocation
     */
    public static void saveParamChangesAsXML(final String serverAddr, final String serverPort, final String threadCnt, final Logger LOGGER, final String fileLocation) {
        try {
            Properties props = new Properties();
            props.setProperty(AppConstants.SERVER_ADDRESS_KEY, serverAddr);
            props.setProperty(AppConstants.SERVER_PORT_KEY, serverPort);
            props.setProperty(AppConstants.NUMBER_OF_THREADS_KEY, threadCnt);
            File f = new File(fileLocation);
            OutputStream out = new FileOutputStream(f);
            props.storeToXML(out, AppConstants.FILE_INFO);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE,AppConstants.EXCAPTION_KEY, e);
        }
    }
    /**
     * This is use for show data from properties file.
     */
    public static void ReadParamXML(){
      //Reading properties file in Java example
        Properties properties = new Properties();
        FileInputStream fis;
        try {
            fis = new FileInputStream(AppConstants.FILE_LOCATION_XML);
            //loading properties from properties file
            properties.loadFromXML(fis);
            //reading properties
            LOGGER.info(properties.getProperty(AppConstants.SERVER_ADDRESS_KEY, AppConstants.SERVER_ADDRESS_DEFAULT));
            LOGGER.info(properties.getProperty(AppConstants.SERVER_PORT_KEY, AppConstants.SERVER_PORT_DEFAULT));
            LOGGER.info(properties.getProperty(AppConstants.NUMBER_OF_THREADS_KEY, AppConstants.NUMBER_OF_THREADS_DEFAULT));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            LOGGER.log(Level.SEVERE,AppConstants.EXCAPTION_KEY, e);
        }
      
       

    }
}
