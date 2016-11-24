package com.arjun.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author NIC
 * @version 1.0 This class use to simple properties(Read/Write).
 */
public class ReadProperties {
    /**
     * Create instance of simple java logger.
     */
    private static final Logger LOGGER = Logger.getLogger(ReadProperties.class.getName());

    /**
     * This is main method take String array as argument.
     * 
     * @param args
     */
    public static void main(String[] args) {
        Properties prop = new Properties();
        InputStream input = null;
        showPropertiesFromResourceDirectory(prop, input, LOGGER);
        showPropertiesFromSamePackage(prop, input, LOGGER);

    }

    /**
     * This method use for read and print properties from resource
     * directory. This method take properties as Properties type and
     * inputStream as InputStream type object.
     * 
     * @param properties
     * @param inputStream
     */
    private static void showPropertiesFromResourceDirectory(Properties properties, InputStream inputStream, Logger LOGGER) {
        try {

            String filename = "config.properties";
            inputStream = ReadProperties.class.getClassLoader().getResourceAsStream(filename);

            if (inputStream == null) {
                LOGGER.info("Sorry, unable to find " + filename);
                return;
            }

            // load a properties file from class path, inside static method
            properties.load(inputStream);
            // get the property value and print it out
            LOGGER.info(properties.getProperty("database", "oracle"));
            LOGGER.info(properties.getProperty("dbuser", "user"));
            LOGGER.info(properties.getProperty("dbpassword", "passs"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    LOGGER.log(Level.SEVERE, "Exception occur", ex);
                }
            }
        }
    }

    /**
     * This method use for read and print properties from same package
     * name. This method take properties as Properties type and inputStream
     * as InputStream type object.
     * 
     * @param properties
     * @param inputStream
     */
    private static void showPropertiesFromSamePackage(Properties properties, InputStream inputStream, Logger LOGGER) {
        try {
            String fileSamePackage = "test.properties";
            inputStream = ReadProperties.class.getResourceAsStream(fileSamePackage);

            if (inputStream == null) {
                LOGGER.info("Sorry, unable to find " + fileSamePackage);
                return;
            }
            // load a properties file from class path, inside static method
            properties.load(inputStream);
            // get the property value and print it out second( Test
            // property)
            LOGGER.info(properties.getProperty("database", "test"));
            LOGGER.info(properties.getProperty("dbuser", "root"));
            LOGGER.info(properties.getProperty("dbpassword", "root"));
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    LOGGER.log(Level.SEVERE, "Exception occur", ex);
                }
            }
        }
    }

}


