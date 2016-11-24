package com.arjun.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * This part of code use for create file and insert properties 
 * inside these files.  
 * @author NIC
 *
 */
public class WriteProperties {
    /**
     * It is main method take string array as argument.
     * @param args
     */
    public static void main(String[] args) { /**
         * Create instance of simple java logger.
         */
        final Logger LOGGER = Logger.getLogger(ReadProperties.class.getName());
       // Call method to save properties.
       saveParamChanges(AppConstants.SERVER_ADDRESS, AppConstants.SERVER_PORT, AppConstants.NUMBER_OF_THREADS, LOGGER, AppConstants.FILE_LOCATION_JAVA );
    }
    /**
     * This method take serverAddr,serverPort,threadCnt,LOGGER as String type parameters.
     * @param serverAddr
     * @param serverPort
     * @param threadCnt
     * @param LOGGER
     */
    public static void saveParamChanges(final String serverAddr,final String serverPort,final String threadCnt, final Logger LOGGER ,final String fileLocation ) {
        try {
            Properties props = new Properties();
            props.setProperty(AppConstants.SERVER_ADDRESS_KEY, serverAddr);
            props.setProperty(AppConstants.SERVER_PORT_KEY, serverPort);
            props.setProperty(AppConstants.NUMBER_OF_THREADS_KEY, threadCnt);
            File f = new File(fileLocation);
            OutputStream out = new FileOutputStream(f);
            props.store(out, AppConstants.FILE_INFO);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE,AppConstants.EXCAPTION_KEY, e);
        }
    }
}
