package com.utils;


import org.testng.annotations.Test;

import java.io.*;
import java.util.*;

public class PropertyReader {
    protected static InputStream inputStream;
   static HashMap<String,String>result=new HashMap<String, String>();


    public static HashMap<String, String> getFileinfo(String fileinfo) throws IOException {
        try {

            Properties prop = new Properties();
           String propFile=fileinfo;
            //specifying the property file using Class loader
            inputStream = PropertyReader.class.getClass().getResourceAsStream(propFile);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("Property file" +propFile+ "is not found on the class path");
            }

            Set propNames = prop.stringPropertyNames();
            Iterator<String> itr = propNames.iterator();
            while (itr.hasNext()) {
                 String key = itr.next(); //return the key
                  result.put(key, prop.getProperty(key));//store (key, value) to result variable.Since result declared has hashmap


            }

            inputStream.close();
        } catch (Exception e)
        {
            System.out.print("Exception"+e);

        }
      return result;

    }



}
